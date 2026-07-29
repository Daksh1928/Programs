package com.devanshu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.devanshu.model.Student;

public class LaunchFirstApp {

    public static void main(String[] args) {
        //Step 1 Configuration Object 
        Configuration config = new Configuration();
        //Step 2 configure hibernate.cfg.xml file to Configuration Object 
        config.configure("hibernate.cfg.xml");
        //Step 3 Create Session Factory Object 
        SessionFactory sessionFactory = config.buildSessionFactory();
        // try (SessionFactory sessionFactory = config.buildSessionFactory()) {
        //     System.out.println("Hibernate session factory created successfully.");
        // }

        // Step 4 Get the Session Object form Session Factory 
        Session session = sessionFactory.openSession();

        // Step 5 Begin the Transaction within Session
        Transaction transaction = session.beginTransaction();

        Student student = new Student();

        student.setSid(1);
        student.setsName("Devanshu Rana");
        student.setScity("Meerut");

        //Step 6 Perfome Operation 
        session.save(student);

        //Step 7 Performing Transaction operations
        transaction.commit();

        //Step 8
        session.close();

    }
}
