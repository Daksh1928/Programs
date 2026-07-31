package com.blackbox.app;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.blackbox.model.Employee1;

public class LaunchSelective {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee1.class)
				.buildSessionFactory();

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter id of employee 1: ");
			Integer id1 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter name of employee 1: ");
			String name1 = scanner.nextLine();
			System.out.print("Enter city of employee 1: ");
			String city1 = scanner.nextLine();
			System.out.print("Enter age of employee 1: ");
			Integer age1 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter phone number of employee 1: ");
			long num1 = Long.parseLong(scanner.nextLine());
			System.out.print("Enter email of employee 1: ");
			String mail1 = scanner.nextLine();
			System.out.print("Enter id of employee 2: ");
			Integer id2 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter name of employee 2: ");
			String name2 = scanner.nextLine();
			System.out.print("Enter city of employee 2: ");
			String city2 = scanner.nextLine();
			System.out.print("Enter age of employee 2: ");
			Integer age2 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter phone number of employee 2: ");
			long num2 = Long.parseLong(scanner.nextLine());
			System.out.print("Enter email of employee 2: ");
			String mail2 = scanner.nextLine();
			System.out.print("Enter id of employee 3: ");
			Integer id3 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter name of employee 3: ");
			String name3 = scanner.nextLine();
			System.out.print("Enter city of employee 3: ");
			String city3 = scanner.nextLine();
			System.out.print("Enter age of employee 3: ");
			Integer age3 = Integer.valueOf(scanner.nextLine());
			System.out.print("Enter phone number of employee 3: ");
			long num3 = Long.parseLong(scanner.nextLine());
			System.out.print("Enter email of employee 3: ");
			String mail3 = scanner.nextLine();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee1 emp4 = new Employee1();
			emp4.seteId(id1);
			emp4.seteName(name1);
			emp4.seteCity(city1);
			emp4.seteAge(age1);
			emp4.setePhone(num1);
			emp4.setEmail(mail1);
			session.persist(emp4);
			Employee1 emp5 = new Employee1();
			emp5.seteId(id2);
			emp5.seteName(name2);
			emp5.seteCity(city2);
			emp5.seteAge(age2);
			emp5.setePhone(num2);
			emp5.setEmail(mail2);
			Employee1 emp6 = new Employee1();

			emp6.seteId(id3);
			emp6.seteName(name3);
			emp6.seteCity(city3);
			emp6.seteAge(age3);
			emp6.setePhone(num3);
			emp6.setEmail(mail3);
 
			session.persist(emp5);
			session.persist(emp6);

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
