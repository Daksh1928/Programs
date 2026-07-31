package com.Dataretrivel.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Dataretrive.model.Student;

public class GetRecordApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = null;
		try {
			session = sessionFactory.openSession();
			// Student student1 = session.get(Student.class, 1);
			// Student student2 = session.get(Student.class, 2);
			// Student student1 = session.load(Student.class, 1);
			// Student student2 = session.load(Student.class, 2);
			Student student1 = session.getReference(Student.class, 1);
			Student student2 = session.getReference(Student.class, 2);
			System.out.print(student1);
			System.out.print(student2);
			Student student3 = session.getReference(Student.class, 1);
			Student student4 = session.getReference(Student.class, 2);
			System.out.print(student3);
			System.out.print(student4);
			// if (student1 != null && student2 != null) {
			// System.out.println("ID is : " + student1.getSid());
			// System.out.println("Name is : " + student1.getsName());
			// System.out.println("City is : " + student1.getScity());
			// System.out.println("ID is : " + student2.getSid());
			// System.out.println("Name is : " + student2.getsName());
			// System.out.println("City is : " + student2.getScity());
			// } else {
			// System.out.println("Data is not presented on this index ");
			// }
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
