package com.xinghua24;

import org.springframework.stereotype.Component;

public class Endpoint {
    private String url;
    
    public Endpoint(String url) {
        super();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
