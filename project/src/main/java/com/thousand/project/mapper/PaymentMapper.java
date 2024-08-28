package com.thousand.project.mapper;

import com.thousand.project.dto.PaymentDTO;
import com.thousand.project.model.Customer;
import com.thousand.project.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentDTO paymentDTO, Customer customer){
        Payment payment=new Payment();
        payment.setId(paymentDTO.getId());
        payment.setTransactionNumber(paymentDTO.getTransactionNumber());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setAmount(paymentDTO.getAmount());
        payment.setCustomer(customer);
        return payment;
    }


    public PaymentDTO toPaymentDTO(Payment payment){
        return new PaymentDTO(
                payment.getId(),
                payment.getTransactionNumber(),
                payment.getPaymentDate(),
                payment.getPaymentMethod(),
                payment.getAmount(),
                payment.getCustomer().getId()
        );

    }

}
