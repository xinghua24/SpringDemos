package com.xinghua24;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.entity.User;
import com.xinghua24.repo.UserRepository;
import com.xinghua24.repo.UserRepositoryImnpl;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        UserRepository userRepo = context.getBean("userRepository", UserRepositoryImnpl.class);
        
        User newUser = new User();
        newUser.setId(4);
        newUser.setName("Bob");
        newUser.setEmail("bob@bob");
        
        userRepo.insertWithIdReturned(newUser);
        System.out.println("User insert with id " + newUser.getId());
        
        // delete user with id 0
        userRepo.delete(0);
        
        List<User> users = userRepo.list();
        System.out.println(users);
        
        

        context.close();
    }
}
