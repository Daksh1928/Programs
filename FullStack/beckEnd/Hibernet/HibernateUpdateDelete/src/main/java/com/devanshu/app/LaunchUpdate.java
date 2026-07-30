package com.devanshu.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.devanshu.model.Student;

public class LaunchUpdate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Student st = new Student();
			st.setSid(4);
			st.setsName("Eva");
			st.setScity("Meerut");
			Student st2 = new Student();
			st2.setSid(5);
			st2.setsName("Aadi");
			st2.setScity("Modinagar");
			Student st3 = new Student();
			st3.setSid(6);
			st3.setsName("Pari");
			st3.setScity("Modinagar");
			session.remove(st);
			session.remove(st2);
			session.remove(st3);
			flag = true;

		}

		catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
	}
}
