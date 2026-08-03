package com.devanshu.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.devanshu.model.Courses;
import com.devanshu.model.Students;

public class LaunchStandardApp {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		config = new Configuration();
		config.configure();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		//
		// Courses course1 = new Courses();
		// course1.setCourseId(101);
		// course1.setCourseName("Java");
		// course1.setCoursePrice(1000);
		// Courses course2 = new Courses();
		// course2.setCourseId(102);
		// course2.setCourseName("Python");
		// course2.setCoursePrice(2000);
		// Courses course3 = new Courses();
		// course3.setCourseId(103);
		// course3.setCourseName("JavaScript");
		// course3.setCoursePrice(3000);
		//
		// Set<Courses> courses1 = new HashSet<>();
		// courses1.add(course1);
		// courses1.add(course2);
		// courses1.add(course3);
		//
		// Set<Courses> courses2 = new HashSet<>();
		// courses2.add(course1);
		// courses2.add(course2);
		//
		// Students s1 = new Students();
		// s1.setStudentId(1);
		// s1.setStudentName("Marko");
		// s1.setCity("Washington, D.C.");
		// s1.setCourses(courses1);
		// Students s2 = new Students();
		// s2.setStudentId(2);
		// s2.setStudentName("John");
		// s2.setCity("New York");
		// s2.setCourses(courses2);
		// Students s3 = new Students();
		// s3.setStudentId(3);
		// s3.setStudentName("Smith");
		// s3.setCity("Los Angeles");
		// s3.setCourses(courses1);
		System.out.print("###############################################################");
		Students stud1 = session.get(Students.class, 1);
		System.out.println(stud1);
		System.out.print("###############################################################");
		Students stud2 = session.get(Students.class, 2);
		System.out.println(stud2);
		System.out.print("###############################################################");
		Students stud3 = session.get(Students.class, 3);
		System.out.println(stud3);
		System.out.print("###############################################################");
		try {
			transaction = session.beginTransaction();
			// session.persist(s1);
			// session.persist(s2);
			// session.persist(s3);
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			}
			session.close();
			sessionFactory.close();
		}
	}
}
