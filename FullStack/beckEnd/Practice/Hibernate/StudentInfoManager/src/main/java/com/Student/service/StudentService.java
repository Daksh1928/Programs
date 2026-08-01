package com.Student.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Student.model.Student;
import com.Student.util.HibernateUtil;

public class StudentService {

    public void save(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException("Unable to save student. Check database connection and schema.", e);
        }
    }

    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException("Unable to update student. Check database connection and schema.", e);
        }
    }

    public boolean deleteById(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student == null) {
                return false;
            }
            session.remove(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            throw new RuntimeException("Unable to delete student. Check database connection and schema.", e);
        }
    }

    public Optional<Student> findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Student.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Unable to fetch student. Check database connection and schema.", e);
        }
    }

    public List<Student> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Unable to list students. Check database connection and schema.", e);
        }
    }

    public List<Student> findByGrade(String grade) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list().stream()
                    .filter(student -> grade.equalsIgnoreCase(student.getGrade()))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Unable to filter students by grade. Check database connection and schema.", e);
        }
    }
}
