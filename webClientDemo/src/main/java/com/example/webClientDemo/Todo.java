package com.example.webClientDemo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, makeFinal = true)
@ToString
public class Todo {
    private long userId;
    private long id;
    private String title;
    private boolean completed;
}
