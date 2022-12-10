package com.example.demo.service;


import com.example.demo.Repo.CustomerRepo;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerSevice  {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveCustomer(CustomerDTO customerDTO){
        if(customerRepo.existsById(customerDTO.getCusID())){
            return VarList.Duplicated;
        }
        else{
               customerRepo.save(modelMapper.map(customerDTO, Customer.class));
               return VarList.Success;
    }






}
public String updateCustomer(CustomerDTO customerDTO){
        if(customerRepo.existsById(customerDTO.getCusID())){
            customerRepo.save(modelMapper.map(customerDTO,Customer.class));
            return VarList.Success;
}
        else{
            return VarList.No_data_found;
        }

    }
    public List<CustomerDTO> getallCustomers(){
      List<Customer> customerList =  customerRepo.findAll();
      return modelMapper.map(customerList,new TypeToken <List<CustomerDTO>>(){}.getType());

    }

    public CustomerDTO searchCustomer(int cusID){
        if (customerRepo.existsById(cusID)) {
            Customer customer = customerRepo.findById(cusID).orElse(null);

            return modelMapper.map(customer,CustomerDTO.class);
        }
        else{
              return null;
        }

    }
    public String DeleteCustomer(int cusID){
        if(customerRepo.existsById(cusID)){
            customerRepo.deleteById(cusID);
          return VarList.Success;
        }

        else{
           return VarList.No_data_found;
        }
    }



    }