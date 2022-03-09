package com.xinghua24.springdocopenapi;

import lombok.Data;

@Data
public class Greeting {
    private long id;
    private final String content;

}