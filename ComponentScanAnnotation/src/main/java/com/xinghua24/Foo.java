package com.xinghua24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    private Bar bar;
    
    @Autowired
    public Foo(Bar bar){
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}
