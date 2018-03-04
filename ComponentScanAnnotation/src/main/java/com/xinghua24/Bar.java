package com.xinghua24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xinghua24.baz.Baz;

@Component
public class Bar {
    public Baz baz;

    public Baz getBaz() {
        return baz;
    }

    @Autowired
    public void setBaz(Baz baz) {
        this.baz = baz;
    }
}
