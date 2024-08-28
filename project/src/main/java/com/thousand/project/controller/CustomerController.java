package com.thousand.project.controller;

import com.thousand.project.dto.CustomerDTO;
import com.thousand.project.service.CustomerService;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer/")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("register")
    public ResponseEntity<CustomerDTO> register(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.register(customerDTO));
    }
    @GetMapping("getById/{customerId}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable("customerId") Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(customerId));
    }

    @GetMapping("getAllCustomers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping("update")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customerDTO));
    }

    @DeleteMapping("deleteById/{customerId}")
    public ResponseEntity<String> deleteById(@PathVariable("customerId") Long customerId){
        customerService.deleteById(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
