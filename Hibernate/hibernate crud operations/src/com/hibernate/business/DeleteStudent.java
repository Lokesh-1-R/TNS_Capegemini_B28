package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 2);
			session.delete(student);
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=3").executeUpdate();
			session.getTransaction().commit();
			
			
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
