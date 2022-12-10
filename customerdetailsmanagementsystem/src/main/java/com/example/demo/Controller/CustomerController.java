package com.example.demo.Controller;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CustomerSevice;
import com.example.demo.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerSevice customerSevice;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveCustomer")
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            String res = customerSevice.saveCustomer(customerDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.Success);
                responseDTO.setMessage("Success");
                responseDTO.setContent(customerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDTO.setCode(VarList.Duplicated);
                responseDTO.setMessage("Duplicated");
                responseDTO.setContent(customerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.Fail);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            responseDTO.setCode(VarList.Token_Error);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/UpdateCustomer")
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            String res = customerSevice.updateCustomer(customerDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.Success);
                responseDTO.setMessage("Success");
                responseDTO.setContent(customerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (res.equals("01")) {
                responseDTO.setCode(VarList.No_data_found);
                responseDTO.setMessage("Data not found");
                responseDTO.setContent(customerDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.Fail);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            responseDTO.setCode(VarList.Token_Error);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/getALLcustomers")
    public ResponseEntity getallCustomers() {
        try {
            List<CustomerDTO> CustomerDTOList = customerSevice.getallCustomers();

            responseDTO.setCode(VarList.Success);
            responseDTO.setMessage("Success");
            responseDTO.setContent(CustomerDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            responseDTO.setCode(VarList.Token_Error);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/SearchCustomer/{cusID}")
    public ResponseEntity searchCustomer(@PathVariable int cusID) {
        try {
            CustomerDTO CustomerDTO = customerSevice.searchCustomer(cusID);

            responseDTO.setCode(VarList.Success);
            responseDTO.setMessage("Success");
            responseDTO.setContent(CustomerDTO);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            responseDTO.setCode(VarList.Token_Error);
            responseDTO.setMessage("No Customer Avaliable For this cusID");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteCustomer/{cusID}")
    public ResponseEntity DeleteCustomer(@PathVariable int cusID) {
        try {
            String res = customerSevice.DeleteCustomer(cusID);
            if (res.equals("00"))
                responseDTO.setCode(VarList.Success);
            responseDTO.setMessage("Success");
            responseDTO.setContent("Successfully deleted " + cusID);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            responseDTO.setCode(VarList.Token_Error);
            responseDTO.setMessage("No Customer Avaliable For this cusID");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
    



