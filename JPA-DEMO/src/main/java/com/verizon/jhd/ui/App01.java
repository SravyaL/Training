package com.verizon.jhd.ui;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;

import com.verizon.jhd.model.Gender;
import com.verizon.jhd.model.Person;
import com.verizon.jhd.util.JPAUtil;

public class App01 {

	public static void main(String[] args) {
		Person p1 = new Person("Lenka","Sravya", Gender.Feminine,false, LocalDate.of(1996, 9, 19));
//		Person p2 = new Person(101,"Title 2", 450);
//		Person p3 = new Person(101,"Title 3", 175);
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(p1);
//		em.persist(b2);
//		em.persist(b3);
		
		em.getTransaction().commit();
		System.out.println("Data persisted");
		JPAUtil.shutdown();
	}

	}


