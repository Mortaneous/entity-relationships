package com.mortaneous.entityrelationships.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.mortaneous.entityrelationships");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		University u1 = new University("Adamson University");
		University u2 = new University("Mapua Institute of Technology");
		
		Student s1 = new Student("Francisco", "Ronald Jorvet");
		s1.setUniversity(u1);
		Student s2 = new Student("Gapac", "Michael Joseph");
		s2.setUniversity(u2);
		Student s3 = new Student("Roxas", "Ritche");
		s3.setUniversity(u2);
		Student s4 = new Student("Ramirez", "Liza");
		s4.setUniversity(u1);
		Student s5 = new Student("Doe", "John");
		s5.setUniversity(u1);
		
		save(u1);
		save(u2);
		save(s1);
		save(s2);
		save(s3);
		save(s4);
		save(s5);
		
		show(u1);
		
		s5.setUniversity(u2);
		save(s5);
		
		show(u1);
		show(u2);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void show(University university) {
		List<Student> students = university.getStudents();
		
		System.out.println("------------------------------------");
		System.out.println(university.getName() + ":");
		System.out.println("------------------------------------");
		for(Student s : students) {
			System.out.println(s);
		}
	}

	public static void save(University university) {
		entityManager.getTransaction().begin();
		entityManager.persist(university);
		entityManager.getTransaction().commit();
	}

	public static void save(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();

	}

}
