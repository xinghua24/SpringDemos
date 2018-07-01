package com.xinghua24.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Foo {
    private Bar bar;
    
//    @Autowired - omit using Implicit Constructor Injection
    public Foo(Bar bar){
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}
