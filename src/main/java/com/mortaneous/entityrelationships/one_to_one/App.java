package com.mortaneous.entityrelationships.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.mortaneous.entityrelationships");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		
		Address address = new Address("409-G Bulalakaw St.", "Mandaluyong", "Philippines", "1501");
		Employee employee = new Employee("Francisco", "Ronald Jorvet");
		
		employee.setAddress(address);
		address.setEmployee(employee);
		
		save(employee, address);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public static void save(Employee emp, Address add) {
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.persist(add);
		entityManager.getTransaction().commit();
	}

}
