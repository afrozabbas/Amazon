package com.thousand.project.service;

import com.thousand.project.dto.CustomerDTO;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.mapper.CustomerMapper;
import com.thousand.project.model.Customer;
import com.thousand.project.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO register(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        return customerMapper.toCustomerDTO(customerRepo.save(customer));
    }

    @Override
    public CustomerDTO getById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + customerId);
        }
        return customerMapper.toCustomerDTO(optionalCustomer.get());
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = customerMapper.toCustomerDTO(customer);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + customerDTO.getId());
        }
        return customerMapper.toCustomerDTO(customerRepo.save(customerMapper.toCustomer(customerDTO)));
    }

    @Override
    public void deleteById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + customerId);

        }
        customerRepo.deleteById(customerId);
    }


}
