package com.xinghua24;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xinghua24.dao.UserDao;
import com.xinghua24.entity.User;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
	    
	    UserDao userDao = context.getBean("userDao", UserDao.class);
	    List<User> users = userDao.query();
	    System.out.println(users);
	    
		context.close();
	}
}
