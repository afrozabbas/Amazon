package com.thousand.project.controller;

import com.thousand.project.dto.WishListDTO;
import com.thousand.project.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/WishList/")
public class WishlListController {

    private final WishListService wishListService;

    @PostMapping("register")
    public ResponseEntity<WishListDTO> register(@RequestBody WishListDTO wishListDTO){
        return ResponseEntity.status(HttpStatus.OK).body(wishListService.register(wishListDTO));
    }

    @GetMapping("getById/{wishListId}")
    public ResponseEntity<WishListDTO> getById(@PathVariable("wishListId") Long wishListId){
        return ResponseEntity.status(HttpStatus.OK).body(wishListService.getById(wishListId));
    }

    @GetMapping("getAll")
    public List<WishListDTO> getAll(){
        return wishListService.getAll();
    }

    @PutMapping("update")
    public ResponseEntity<WishListDTO> update(@RequestBody WishListDTO wishListDTO){
        return ResponseEntity.status(HttpStatus.OK).body(wishListService.update(wishListDTO));
    }

    @DeleteMapping("deleteById/{wishListId}")
    public ResponseEntity<String> deleteById(@PathVariable("wishListId") Long wishListId){
        wishListService.deleteById(wishListId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
