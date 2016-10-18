package com.xinghua24.entities;

import org.springframework.stereotype.Component;

@Component
public class Foo {
    private Bar bar;
    
    public Foo(Bar bar){
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
    
}
