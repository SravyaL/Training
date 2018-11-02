package com.verizon.jhd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import com.verizon.jhd.model.Employee;
import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.model.composition.Address;
import com.verizon.jhd.util.JPAUtil;

public class App02 {
public static void main(String[] args) {
	Employee p1 = new Employee("Lenka Sravya", Gender.Feminine, LocalDate.of(1996, 9, 19), new Address("15-11-66","Vizag","AP"));
//	Person p2 = new Person(101,"Title 2", 450);
//	Person p3 = new Person(101,"Title 3", 175);
	
	EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	em.getTransaction().begin();
	
	em.persist(p1);
//	em.persist(b2);
//	em.persist(b3);
	
	em.getTransaction().commit();
	System.out.println("Data persisted");
	JPAUtil.shutdown();
}
}
