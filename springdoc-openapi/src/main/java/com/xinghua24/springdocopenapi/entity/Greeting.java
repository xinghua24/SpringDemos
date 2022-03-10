package com.xinghua24.springdocopenapi.entity;

import lombok.Data;

@Data
public class Greeting {
    private long id;
    private final String content;
}