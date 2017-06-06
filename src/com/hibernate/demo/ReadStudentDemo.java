package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("AAA", "BBB", "AAABBB@gmail.com");
			
			//start a transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//My new code
			
			//find out the student's id: primary key
			System.out.println("Saved Student Generated id: " + tempStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction(); 
			
			// retrieve student based on the id : primary key
			System.out.println("\nGetting student with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);			
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} 
		finally {
			factory.close();
		}
		}

}
