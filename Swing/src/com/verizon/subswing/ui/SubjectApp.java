package com.verizon.subswing.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.verizon.subswing.exception.SubjectException;
import com.verizon.subswing.model.Subject;
import com.verizon.subswing.service.SubjectService;
import com.verizon.subswing.service.SubjectServiceImp;

public class SubjectApp {
	static Scanner scan;
	static SubjectService subjectService;

	

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		subjectService = new SubjectServiceImp();
		
		Menu choice = null;
		while(Menu.QUIT!=choice) {
			System.out.println("Choice Id \t Operation");
			System.out.println("--------------------------------");
			for(Menu m : Menu.values()) {
				System.out.println((m.ordinal()+1) +"\t"+m);
			}
			System.out.println("Choice : ");
			int ch = scan.nextInt();
			
			choice = Menu.values()[ch-1];
			
			switch(choice) {
				case ADD :
					doAdd();
					break;
				case DELETE : 
					doDelete();
					break;
				case SEARCH : 
					doSearch();
					break;
				case LIST : 
					doList();
					break;
				case SORT:
					doSort();
					break;
				case QUIT : 
					System.out.println("Program Terminated!");
					break;
			}
		}
		scan.close();

	}
	
	
	public static void doAdd() {
		System.out.println("Enter number of subjects you want to add :");
		int x =scan.nextInt();
		for(int i=0; i<x;i++){
			System.out.println("Enter the subject values(SubjectId, Title, Duration) ");
			Subject c =  new Subject(scan.nextInt(),scan.next(),scan.nextInt());
			try {
				subjectService.add(c);
				System.out.println("\nRecord Added\n");
			} catch (SubjectException e) {
				System.out.println("Err : " + e.getMessage());
			}
		}
	}
	
	
	public static void doSearch() {
		System.out.println("Subject Id : ");
		int id = scan.nextInt();
		
		try {
			Subject c = subjectService.findByID(id);
			if(c!=null){
				System.out.println("\nRecord Found\n");
				System.out.println(c+"\n");
			}
			else
				System.out.println("Subject not found");
		} catch(SubjectException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	public static void doDelete() {
		System.out.println("SubjectId of subject to be removed : ");
		int id = scan.nextInt();
		
		try {
			boolean isDeleted = subjectService.deleteSubject(id);
			if(isDeleted)
				System.out.println("\nRecord Deleted\n");
			else
				System.out.println("\nSubject not found\n");
		} catch(SubjectException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	public static void doList() {
		try {
			List<Subject> subjectList = subjectService.getAllSubjects();
			System.out.println("-----------------------------------\n");
			if(subjectList.isEmpty())
				System.out.println("Set is empty\n");
			else
				for(Subject c:subjectList)
					System.out.println(c+"\n");
			System.out.println("-----------------------------------\n");
		} catch(SubjectException e) {
				System.out.println("Error : "+e.getMessage());
		}
	}
	
	public static void doSort() {
		try{
			SortMenu sm = null;
			System.out.println("Enter sort type (1 - SubjectID, 2 - SubjectTitle, 3 - Duration)");
			int ch2 = scan.nextInt();
			sm = SortMenu.values()[(ch2-1)];
			switch(sm){
				case ID:
					List<Subject> subjectList = subjectService.getAllSubjects();
					Collections.sort(subjectList,new Compare());
					System.out.println("-----------------------------------\n");
					if(subjectList.isEmpty())
						System.out.println("Set is empty\n");
					else
						for(Subject c:subjectList)
							System.out.println(c+"\n");
					System.out.println("-----------------------------------\n");
					break;
				case TITLE:
					List<Subject> subjectList1 = subjectService.getAllSubjects();
					Collections.sort(subjectList1,new Compare1());
					System.out.println("-----------------------------------\n");
					if(subjectList1.isEmpty())
						System.out.println("Set is empty\n");
					else
						for(Subject c:subjectList1)
							System.out.println(c+"\n");
					System.out.println("-----------------------------------\n");
					break;
				case DURATION:
					List<Subject> subjectList2 = subjectService.getAllSubjects();
					Collections.sort(subjectList2,new Compare2());
					System.out.println("-----------------------------------\n");
					if(subjectList2.isEmpty())
						System.out.println("Set is empty\n");
					else
						for(Subject c:subjectList2)
							System.out.println(c+"\n");
					System.out.println("-----------------------------------\n");
					break;
			}
		} catch(SubjectException e){
			System.out.println("Err: "+e.getMessage());
		}
		
	}


}

class Compare implements Comparator<Subject>{
	 
    @Override
    public int compare(Subject s1, Subject s2) {
        if(s1.getSubjectId()>s2.getSubjectId()){
            return 1;
        } else {
            return -1;
        }
    }
}
class Compare1 implements Comparator<Subject>{
	 
    @Override
    public int compare(Subject s1, Subject s2) {
        if(s1.getSubtitle().compareTo(s2.getSubtitle())>0){
            return 1;
        } else {
            return -1;
        }
    }
}
class Compare2 implements Comparator<Subject>{
	 
    @Override
    public int compare(Subject s1, Subject s2) {
        if(s1.getDurationInHours()>s2.getDurationInHours()){
            return 1;
        } else {
            return -1;
        }
    }
}
