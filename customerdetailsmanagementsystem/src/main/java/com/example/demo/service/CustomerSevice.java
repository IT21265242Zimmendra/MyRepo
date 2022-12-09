package com.example.demo.service;


import com.example.demo.Repo.CustomerRepo;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }