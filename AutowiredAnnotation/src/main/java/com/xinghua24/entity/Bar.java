package com.xinghua24.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Bar {

    private Baz baz;

    @Autowired
    public void setDependencies(Baz baz){
        this.baz = baz;
    }

    public Baz getBaz() {
        return baz;
    }
}
