package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class MainController {

    private final ProductRepository productRepo;

    @Autowired
    public MainController( ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
