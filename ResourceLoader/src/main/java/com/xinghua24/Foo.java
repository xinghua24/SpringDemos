package com.xinghua24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class Foo {
    private Resource resource;
    
    public void getResource(){
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        resource = resourceLoader.getResource("classpath:companies.txt");
        
        System.out.println("Resource exists: " + resource.exists());
        System.out.println("Resource isOpen: " + resource.isOpen());
        System.out.println("Resource readable: " + resource.isReadable());
        System.out.println("Resource description: " + resource.getDescription());
        System.out.println("Resource file name: " + resource.getFilename());
        System.out.println("Resource class type: " + resource.getClass().getName());

        
        try {
            System.out.println("Resource URL: " + resource.getURL());
            
            // now read the file
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
