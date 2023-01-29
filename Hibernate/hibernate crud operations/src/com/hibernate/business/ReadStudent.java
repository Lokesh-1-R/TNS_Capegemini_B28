package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating a new Student");
			Student student1 = new Student("Jessica", "jones", "jsjones@marvel.com");
			session.beginTransaction();
			session.save(student1);
			session.getTransaction().commit();
			Session session2 = factory.getCurrentSession();
			session2.beginTransaction();
			
			System.out.println("The Object for the id: "+student1.getId());
			Student student = session2.get(Student.class, student1.getId());
			
			System.out.println("The object is: "+ student);
			session2.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
