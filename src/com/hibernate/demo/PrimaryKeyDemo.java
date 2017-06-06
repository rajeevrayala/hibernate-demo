package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		//create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				//Create Session
				Session session = factory.getCurrentSession();
				
				try {

					//create 3 Student objects
					System.out.println("create 3 new Student object.....");
					Student tempStudent1 = new Student("a", "b", "ab@gmail.com");
					Student tempStudent2 = new Student("c", "d", "cd@gmail.com");
					Student tempStudent3 = new Student("e", "f", "ef@gmail.com");
					
					//start a transaction 
					session.beginTransaction();
					
					//save the student object
					System.out.println("saving the students...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!!!");
				} 
				finally {
					factory.close();
				}
	}

}
