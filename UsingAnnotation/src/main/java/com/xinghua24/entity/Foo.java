package com.xinghua24.entity;

import org.springframework.beans.factory.annotation.Value;

public class Foo {
    
    private String myValue;

    public String getMyValue() {
        return myValue;
    }
    
    @Value("DEF")
    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }
}
