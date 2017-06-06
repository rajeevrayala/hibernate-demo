package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		try {

			//create a Student object
			System.out.println("create new Student object.....");
			Student tempStudent = new Student("Raj", "Ray", "rajeev@gmail.com");
			
			//start a transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student...");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
		} 
		finally {
			factory.close();
		}
		}

}
