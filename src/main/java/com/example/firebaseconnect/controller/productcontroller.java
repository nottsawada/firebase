package com.example.firebaseconnect.controller;


import com.example.firebaseconnect.Entity.Product;
import com.example.firebaseconnect.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class productcontroller {

    @Autowired
    private Productservice productservice;

    @PostMapping("/product")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productservice.saveProduct(product);
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable String name) throws ExecutionException, InterruptedException {

        return productservice.getProductDetails(name);
    }


}
