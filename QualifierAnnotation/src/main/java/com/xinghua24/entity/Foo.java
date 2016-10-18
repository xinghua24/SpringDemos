package com.xinghua24.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Foo {

    private Bar bar;

    @Autowired
    @Qualifier("barB")
    public void setBar( Bar bar) {
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}
