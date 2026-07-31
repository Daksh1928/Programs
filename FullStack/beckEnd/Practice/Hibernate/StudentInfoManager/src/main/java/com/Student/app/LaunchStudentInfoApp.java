package com.Student.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.Student.model.Student;

public class LaunchStudentInfoApp {
     public static void main(String... args) {
          Configuration config = new Configuration().configure();
          config.addAnnotatedClass(Student.class);
          ServiceRegistry registry = new StandardServiceRegistryBuilder()
                  .applySettings(config.getProperties())
                  .build();

          try (SessionFactory sessionFactory = config.buildSessionFactory(registry);
               Session session = sessionFactory.openSession()) {

              Transaction tx = session.beginTransaction();
              Student s = new Student();
              s.setId(1);
              s.setName("Alice");
              s.setCity("Wonderland");
              s.setMarks(95);

              session.persist(s);
              tx.commit();

              System.out.println("Saved: " + s);
          } catch (HibernateException e) {
              e.printStackTrace();
          }
     }
}
