package com.thousand.project.controller;

import com.thousand.project.dto.ItemDTO;
import com.thousand.project.model.Item;
import com.thousand.project.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item/")
public class ItemController {
    private final ItemService itemService;

    @PostMapping("register")
    public ResponseEntity<ItemDTO> register(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.register(itemDTO));
    }

    @GetMapping("getById/{itemId}")
    public ResponseEntity<ItemDTO> getById(@PathVariable("itemId") Long itemId){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getById(itemId));
    }

    @GetMapping("getAll")
    public List<ItemDTO> getAll(){
        return itemService.getAll();
    }

    @PutMapping("update")
    public ResponseEntity<ItemDTO> update(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.update(itemDTO));
    }

    @DeleteMapping("deleteById/{itemId}")
    public ResponseEntity<String> deleteById(@PathVariable("itemId") Long itemId){
        itemService.deleteById(itemId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
