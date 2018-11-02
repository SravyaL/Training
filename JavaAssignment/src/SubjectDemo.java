import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.verizon.ui.Menu;

public class SubjectDemo {
	static Scanner scan;
	static Set<Subject> s = new TreeSet<Subject>(); 
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		Menu choice = null;
		while(Menu.Quit!=choice){
			System.out.println("Choice \t Operation");
			System.out.println("....................");
			for(Menu m: Menu.values()){
				System.out.println(m.ordinal()+"\t"+m);
			}
			System.out.println("Choice: ");
			int ch = scan.nextInt();
			
			choice = Menu.values()[ch];
			switch(choice){
			case ADD:
				doAdd();
				break;
			case DELETE: 
				doDelete();
				break;
			case DBID: 
				displayByID(); 
				break;
			case SEARCH: 
				doSearch(); 
				break;
			case DisplayByDuration: 
				displayByDuration(); 
				break;
			case DisplayByTitle:
				displayByTitle();
				break;
			case Quit: 
				System.out.println("Prog terminated!");
				break;
			}
		}
		scan.close();
	}
	private static void displayByTitle() {
		
		
	}
	private static void displayByDuration() {
		
		
	}
	private static void doSearch() {
		
		
	}
	private static void displayByID() {
		for(Subject sub: s){
		System.out.println(sub);
	}
		
	}
	private static void doDelete() {
		System.out.println("Enter subject ID, Subject Title and Duration of element to delete: ");
		Scanner input = new Scanner(System.in);
		Subject s1 = new Subject(input.nextInt(),input.next(),input.nextInt());
		boolean isremoved = s.remove(s1); 
		if(isremoved)
			System.out.println("Element Removed");
		
		
	}
	private static void doAdd() {
		Scanner input = new Scanner(System.in);
		Subject s1 = new Subject();
		System.out.println("Enter subject ID: ");
		s1.setSubjectId(input.nextInt());
		System.out.println("Enter Subject title: ");
		s1.setSubtitle(input.next());
		System.out.println("Enter Subject duration: ");
		s1.setDurationInHours(input.nextInt());
		s.add(s1);
		
	}
	}


