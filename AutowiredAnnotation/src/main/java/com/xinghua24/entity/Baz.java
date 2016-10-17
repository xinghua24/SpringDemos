package com.xinghua24.entity;

import org.springframework.beans.factory.annotation.Value;

public class Baz {
    
    private String myValue;

    public String getMyValue() {
        return myValue;
    }

    @Value("XYZ")
    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }
}
