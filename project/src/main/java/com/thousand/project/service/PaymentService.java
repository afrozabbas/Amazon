package com.thousand.project.service;

import com.thousand.project.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO register(PaymentDTO paymentDTO);

    PaymentDTO getById(Long paymentId);

    List<PaymentDTO> getAllPayments();

    PaymentDTO update(PaymentDTO paymentDTO);

    void deleteById(Long paymentId);
}
