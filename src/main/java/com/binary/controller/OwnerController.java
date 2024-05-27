package com.binary.controller;

import com.binary.Entity.Owner;
import com.binary.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/")
    public String ownerMessage() {
        return "Hello, This is from Rest Controller for Owner";
    }

    @GetMapping("/list")
    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerService.getAllOwners();
    }

    @GetMapping("/newlist")
    public ResponseEntity<List<Owner>> getOwners() {
        return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
    }

    @GetMapping("/list1")
    public ResponseEntity<List<Owner>> getAllOwnersByName() {
        return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.createOwner(owner), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable long id, @RequestBody Owner updatedOwner) {
        return new ResponseEntity<>(ownerService.updateOwner(id, updatedOwner), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteOwner(@PathVariable long id) {
        return new ResponseEntity<>(ownerService.deleteOwner(id), HttpStatus.OK);
    }
}
