package com.devasnhu.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.devanshu.model.Students;


public class GetRecordApp {

	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(Students.class).buildSessionFactory();
		Session session1 = null;
		
		try {
			session1 =sessionfactory.openSession();
//		Query<Students> query = session1.createQuery("FROM Students WHERE scity=:city",Students.class);
			Query<String> query = session1.createQuery("SELECT sName FROM Students WHERE scity=:city");
		query.setParameter("city","Meerut");
		List<String> ListStudent = query.list();
//		
//		for(Students s : ListStudent) {
//			System.out.println(s);
//		}
	  ListStudent.forEach((s)->System.out.println(s));		
		}
		catch(HibernateException e )
		{
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session1.clear();
			sessionfactory.close();
			
		}
	}
}
//, ,  , e, etc., DSA 