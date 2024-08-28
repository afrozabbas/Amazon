package com.thousand.project.controller;

import com.thousand.project.dto.PaymentDTO;
import com.thousand.project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("register")
    public ResponseEntity<PaymentDTO> register(@RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.register(paymentDTO));
    }

    @GetMapping("getById/{paymentId}")
    public ResponseEntity<PaymentDTO> getById(@PathVariable("paymentId") Long paymentId){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getById(paymentId));
    }

    @GetMapping("getAllPayments")
    public List<PaymentDTO> getAllPayments(){
       return paymentService.getAllPayments();
    }

    @PutMapping("update")
    public ResponseEntity<PaymentDTO> update(@RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.update(paymentDTO));
    }

    @DeleteMapping("deleteById/{paymentId}")
    public ResponseEntity<String> deleteById(@PathVariable("paymentId") Long paymentId){
        paymentService.deleteById(paymentId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
