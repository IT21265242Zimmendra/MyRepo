package com.example.demo.Controller;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.CustomerSevice;
import com.example.demo.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
private CustomerSevice customerSevice;
    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping(value = "/saveCustomer")
public ResponseEntity saveCustomer(@RequestBody CustomerDTO customerDTO){
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
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);
        } else {
            responseDTO.setCode(VarList.Fail);
            responseDTO.setMessage("Error");
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO,HttpStatus.BAD_REQUEST);

        }
    }
    catch (Exception ex){
        responseDTO.setCode(VarList.Token_Error);
        responseDTO.setMessage(ex.getMessage());
        responseDTO.setContent(null);
        return new ResponseEntity(responseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}