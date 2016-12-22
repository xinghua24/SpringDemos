package com.xinghua24;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xinghua24.entity.AutoUser;
import com.xinghua24.entity.Vehicle;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SessionFactory sf = context.getBean("sessionFactory", SessionFactory.class);
        Session session= sf.openSession();
        
        session.beginTransaction();
        AutoUser user = (AutoUser) session.get(AutoUser.class, 1L);
        System.err.println(user);
        System.err.println(user.getVehicles());
        
        System.err.println("add vehicle");
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Colora");
        vehicle.setUser(user);
        session.persist(vehicle);
        System.err.println(vehicle);
        session.getTransaction().commit();
        session.close();
        
        
        session= sf.openSession();
        AutoUser user1 = (AutoUser) session.get(AutoUser.class, 1L);
        System.err.println(user1);
        System.err.println(user1.getVehicles());
        session.close();

        context.close();
    }
}
