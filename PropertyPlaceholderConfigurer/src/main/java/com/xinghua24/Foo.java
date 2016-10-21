package com.xinghua24;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    
    @Value("${properties.property1}")
    private String value1;
    
    @Value("${properties.property2}")
    private String value2;
    
    @Value("${properties.property3}")
    private String value3;

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    @Override
    public String toString() {
        return "Foo [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + "]";
    }
    
    
}
