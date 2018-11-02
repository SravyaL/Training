package com.verizon.sad.ui;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.verizon.sad.exception.SubjectClassException;
import com.verizon.sad.model.*;
import com.verizon.sad.service.SubjectService;
import com.verizon.sad.service.SubjectServiceImpl;


public class SubjectDemo {
	static Scanner scan;
	static SubjectService subjectservice;

	public static void main(String[] args) {
		Set<Subject> s = new TreeSet<Subject>();
		subjectservice = new SubjectServiceImpl();

		scan = new Scanner(System.in);
		Menu choice = null;
		while (Menu.Quit != choice) {
			System.out.println("Choice \t Operation");
			System.out.println("....................");
			for (Menu m : Menu.values()) {
				System.out.println(m.ordinal() + "\t" + m);
			}
			System.out.println("Choice: ");
			int ch = scan.nextInt();

			choice = Menu.values()[ch];
			switch (choice) {
			case ADD:
				Subject s1 = new Subject();
				System.out.println("Enter subject ID: ");
				s1.setSubjectId(scan.nextInt());
				System.out.println("Enter Subject title: ");
				s1.setSubtitle(scan.next());
				System.out.println("Enter Subject duration: ");
				s1.setDurationInHours(scan.nextInt());
				try{
					subjectservice.add(s1);
					System.out.println("Record added!");
				}catch(SubjectClassException e){
					System.out.println("Err: "+ e.getMessage());
					
				}
				break;
			case DELETE:
				Subject s2 = new Subject();
				System.out.println("Enter subject ID: ");
				s2.setSubjectId(scan.nextInt());
				System.out.println("Enter Subject title: ");
				s2.setSubtitle(scan.next());
				System.out.println("Enter Subject duration: ");
				s2.setDurationInHours(scan.nextInt());
				try{
							boolean isDeleted = subjectservice.deleteSubject(s2.getSubjectId(),s2.getSubtitle(),s2.getDurationInHours());
							
							if(isDeleted)
								System.out.println("Record deleted");
							else
								System.out.println("Contact not found!");
						}catch(SubjectClassException e ){
							System.out.println("Err: "+ e.getMessage());
						}

						break;
				
			case DBID:
				try {
					List<Subject> subjectList=subjectservice.Display();
					Collections.sort(subjectList,new SortByID());
					for(Subject c:subjectList)
					System.out.println(c);
				} catch (SubjectClassException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								break;
			case SEARCH:

				System.out.println("Enter ID:");
				Scanner i2 = new Scanner(System.in);
				int id = i2.nextInt();
				try {
					Subject c=subjectservice.findByID(id);
					if(c!=null)
					System.out.println(c);
					else
					System.out.println("Not available");

					} catch (SubjectClassException e) {
					System.out.println("Err:" + e.getMessage());
					}
				
				break;
			case DisplayByDuration:
				try {
					List<Subject> subjectList=subjectservice.Display();
					Collections.sort(subjectList,new SortByDuration());
					for(Subject c:subjectList)
					System.out.println(c);
				} catch (SubjectClassException e) {
					e.printStackTrace();
				}
				break;

			case DisplayByTitle:
				try {
					List<Subject> subjectList=subjectservice.Display();
					Collections.sort(subjectList,new SortByTitle());
					for(Subject c:subjectList)
					System.out.println(c);
				} catch (SubjectClassException e) {
					e.printStackTrace();
				}
				break;
			case Quit:
				System.out.println("Prog terminated!");
				break;
			}
		}
		scan.close();
	}

}
