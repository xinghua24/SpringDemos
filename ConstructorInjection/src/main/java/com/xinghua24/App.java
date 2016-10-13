package com.xinghua24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	//load application context from classpath. notice Classpath: can be omitted 
    	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
    	
    	UserView userView =  context.getBean("userView", UserView.class);
    	
    	userView.displayUser();
    	
    	((ClassPathXmlApplicationContext)context).close();
    }
}