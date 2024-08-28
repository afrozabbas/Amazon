package com.thousand.project.service;

import com.thousand.project.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO register(CustomerDTO customerDTO);

    CustomerDTO getById(Long customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO update(CustomerDTO customerDTO);

    void deleteById(Long customerId);
}
