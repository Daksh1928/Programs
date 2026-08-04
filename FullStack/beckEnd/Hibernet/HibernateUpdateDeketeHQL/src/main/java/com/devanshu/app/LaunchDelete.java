package com.devanshu.app;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.devanshu.model.Students;

public class LaunchDelete {

    public static void main(String... args) {

        SessionFactory sessionfactory = new Configuration().configure().addAnnotatedClass(Students.class)
                .buildSessionFactory();
        Session session1 = null;
        Transaction transaction = null;
        boolean flag = false;
        int count = 0;

        try {
            session1 = sessionfactory.openSession();
            transaction = session1.beginTransaction();
            // count = session1.createQuery("UPDATE Students SET scity=
            // :city").setParameter("city", "Noida").executeUpdate();
            count = session1.createMutationQuery("DELETE FROM  Students WHERE  sid=:id").setParameter("id", 5).executeUpdate();
            flag = true;
        } catch (HibernateException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                System.out.println("Number of rows effected during entire process : " + count);
            } else {
                transaction.rollback();
            }
            session1.clear();
            sessionfactory.close();

        }
    }
}