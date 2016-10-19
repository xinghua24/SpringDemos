package com.xinghua24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Baz {
    public String myValue;

    public String getMyValue() {
        return myValue;
    }

    @Autowired
    public void setMyValue(@Value("Hello!!") String myValue) {
        this.myValue = myValue;
    }
}
