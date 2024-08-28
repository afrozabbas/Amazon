package com.thousand.project.mapper;

import com.thousand.project.dto.CustomerDTO;
import com.thousand.project.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerDTO customerDTO){
        Customer customer=new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNo(customerDTO.getPhoneNo());
        return customer;
    }

    public CustomerDTO toCustomerDTO(Customer customer){
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getAddress(),
                customer.getPhoneNo()
        );
    }
}
