package com.hibernate.business;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			//Create more Students 
			Student student2 = new Student("Gabe", "Mark", "gabe@e.com");
			Student student3 = new Student("Jac", "Emioy", "emily@w.com");
			Student student4 = new Student("Evans", "Chris", "j@w.com");
			Student student5 = new Student("Tiger", "King", "kingtiger@1sd3.com");

			//Start transaction 
			session.beginTransaction();

			//Save the object
			session.save(student2);
			session.save(student3);
			session.save(student4);
			session.save(student5);
			

			//Commit
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
