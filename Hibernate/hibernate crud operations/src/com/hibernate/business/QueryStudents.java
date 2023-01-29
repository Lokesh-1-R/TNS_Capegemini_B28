package com.hibernate.business;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class QueryStudents {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			//Start transaction 
			session.beginTransaction();

			
			//Query Students and display
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			//Query For last Name starting with jones
			System.out.println("Student last name with jones");
			List<Student> theStudents2 = session.createQuery("from Student s where s.lastName='jones'").getResultList();
			displayStudents(theStudents2);
			
			//Commit
			session.getTransaction().commit();

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student:theStudents) {
			System.out.println(student);
		}
	}

}
