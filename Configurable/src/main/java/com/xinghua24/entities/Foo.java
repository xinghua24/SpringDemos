package com.xinghua24.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class Foo {
	
    @Autowired
    private Bar bar;


    public void greet(){
        bar.greet();
    }
	
}
