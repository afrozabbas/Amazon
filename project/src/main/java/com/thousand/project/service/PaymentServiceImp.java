package com.thousand.project.service;

import com.thousand.project.dto.PaymentDTO;
import com.thousand.project.exception.CustomerNotFoundException;
import com.thousand.project.exception.PaymentNotFoundException;
import com.thousand.project.mapper.PaymentMapper;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Payment;
import com.thousand.project.repo.CustomerRepo;
import com.thousand.project.repo.PaymentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {

    private final CustomerRepo customerRepo;
    private final PaymentMapper paymentMapper;
    private final PaymentRepo paymentRepo;


    @Override
    public PaymentDTO register(PaymentDTO paymentDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(paymentDTO.getCustomerId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + paymentDTO.getCustomerId());
        }
        Customer customer = optionalCustomer.get();
        Payment payment = paymentMapper.toPayment(paymentDTO, customer);
        return paymentMapper.toPaymentDTO(paymentRepo.save(payment));
    }

    @Override
    public PaymentDTO getById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepo.findById(paymentId);
        if (optionalPayment.isEmpty()) {
            throw new PaymentNotFoundException("Payment not found with Id:" + paymentId);

        }
        return paymentMapper.toPaymentDTO(optionalPayment.get());
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepo.findAll();
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for (Payment payment : payments) {
            PaymentDTO paymentDTO = paymentMapper.toPaymentDTO(payment);
            paymentDTOS.add(paymentDTO);
        }
        return paymentDTOS;
    }

    @Override
    public PaymentDTO update(PaymentDTO paymentDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(paymentDTO.getCustomerId());
        Optional<Payment> optionalPayment = paymentRepo.findById(paymentDTO.getId());
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not found with Id:" + paymentDTO.getCustomerId());

        }
        if (optionalPayment.isEmpty()) {
            throw new PaymentNotFoundException("Payment not found with Id:" + paymentDTO.getId());
        }
        Customer customer = optionalCustomer.get();
        Payment payment = paymentMapper.toPayment(paymentDTO, customer);
        return paymentMapper.toPaymentDTO(paymentRepo.save(payment));
    }

    @Override
    public void deleteById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepo.findById(paymentId);
        if (optionalPayment.isEmpty()) {
            throw new PaymentNotFoundException("Payment not found with Id:" + paymentId);
        }
        paymentRepo.deleteById(paymentId);
    }
}
