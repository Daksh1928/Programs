package com.devasnhu.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.devanshu.model.Answer;
import com.devanshu.model.Question;

public class LaunchStandardApp {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionfactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		config = new Configuration();
		config.configure();
		sessionfactory = config.buildSessionFactory();
		session = sessionfactory.openSession();

		Question q1 = new Question();
		q1.setId(1);
		q1.setQuestion("What is Hibernate?");

		Answer answer1 = new Answer();
		answer1.setId(1);
		answer1.setAnswer("Hibernate is a orm framwork");
		q1.setAnswer(answer1);

		Question q2 = new Question();
		q2.setId(2);
		q2.setQuestion("What are you learning?");

		Answer answer2 = new Answer();
		answer2.setId(2);
		answer2.setAnswer("I am currently learning hibernate Which is a part of my journy to become a Java Devloper ");
		q2.setAnswer(answer2);
		try {
			transaction = session.beginTransaction();

			System.out.println("Before Persist");

			session.persist(q1);
			session.persist(q2);

			System.out.println("After Persist");

			transaction.commit();

			System.out.println("Commit Successful");
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(flag);
			session.close();
			sessionfactory.close();
		}
	}

}
