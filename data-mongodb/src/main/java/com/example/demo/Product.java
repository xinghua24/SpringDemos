package com.example.demo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "product")
@Data
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private double price;
    private Date created;
}
