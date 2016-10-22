package com.xinghua24;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bar {
    
    @PostConstruct
    public void init() {
        System.out.println("Bar init() called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bar destroy() called");
    }
}
