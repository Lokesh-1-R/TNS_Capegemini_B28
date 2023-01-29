package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//Create a Student 
			System.out.println("Creating a new Student");
			Student student1 =  new Student("Jackson", "jeff", "jeff@123.com");
			
			//Start transaction 
			session.beginTransaction();
			
			//Save the object
			session.save(student1);
			
			//Commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}

	}

}
