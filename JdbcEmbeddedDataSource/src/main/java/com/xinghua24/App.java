package com.xinghua24;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.dao.UserDao;
import com.xinghua24.entity.User;

public class App {
	public static void main(String[] args) {
	    ClassPathXmlApplicationContext
	    context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    
	    UserDao userDao = context.getBean("userDao", UserDao.class);
	    List<User> users = userDao.query();
	    System.out.println(users);
	    
		context.close();
	}
}
