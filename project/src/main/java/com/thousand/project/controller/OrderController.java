package com.thousand.project.controller;

import com.thousand.project.dto.OrderDTO;
import com.thousand.project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Order/")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("register")
    public ResponseEntity<OrderDTO> register(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.register(orderDTO));
    }

    @GetMapping("getById/{orderId}")
    public ResponseEntity<OrderDTO> getById(@PathVariable("orderId") Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(orderId));
    }

    @GetMapping("getAll")
    public List<OrderDTO> getAll(){
      return   orderService.getAll();
    }

    @PutMapping("update")
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.update(orderDTO));
    }

    @DeleteMapping("deleteById/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable("orderId") Long orderId){
        orderService.deleteById(orderId);
    return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
