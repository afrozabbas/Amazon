package com.thousand.project.controller;

import com.thousand.project.dto.CartDTO;
import com.thousand.project.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart/")
public class CartController {

    private final CartService cartService;

    @PostMapping("register")
    public ResponseEntity<CartDTO> register(@RequestBody CartDTO cartDTO){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.register(cartDTO));
    }

    @GetMapping("getById/{cartId}")
    public ResponseEntity<CartDTO> getById(@PathVariable("cartId") Long cartId){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getById(cartId));
    }

    @GetMapping("getAll")
    public List<CartDTO> getAll(){
        return cartService.getAll();
    }

    @PutMapping("update")
    public ResponseEntity<CartDTO> update(@RequestBody CartDTO cartDTO){
        return ResponseEntity.status(HttpStatus.OK).body(cartService.update(cartDTO));
    }

    @DeleteMapping("deleteById/{cartId}")
    public ResponseEntity<String> deleteById(@PathVariable("cartId") Long cartId){
        cartService.deleteById(cartId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }


}
