/**
 * 
 */
package com.mindtree.client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mindtree.model.Employee;
import com.mindtree.model.Event;
import com.mindtree.service.EventService;
import com.mindtree.service.impl.EventServiceImpl;

/**
 * @author Nephilim
 *
 */
public class EventManager {
	
	static Session session;
	static EventService service = new EventServiceImpl();

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	
		
		
		Transaction tx = null;
		int choice = 0;
		/*Employee emp1=new Employee("M1027338", "Ujwal", new Date(),"ujwal.vssut@gmail.com");
		Event event1= new Event("Coding", "Bring the coder inside you");*/
	
							
		do{
			service.openSession();		
			choice = getUserInput();
			switch (choice) {
			case 1:
				Employee emp1 = getEmpInput();
				Event event1 = getEventInput();
				service.registerEmpForEvent(emp1, event1);
				break;
			case 2:
				List<Employee> employees = service.getAllEmployees();
				displayEmp(employees);
				break;				
			}
			service.closeSession();		
		}
		while(choice!=0);
		
		System.out.println("THANK YOU for using our EVENT REGISTRATION SYSTEM");
		
		
		
	}

	private static void displayEmp(List<Employee> list) {
		// TODO Auto-generated method stub
		System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.printf("%-22s%-22s%-22s%-30s%-22s\n","MID","Name","Email","DoJ","Events");
		
		for (Employee emp : list) {
			System.out.printf("%-22s%-22s%-22s%-27s%-22s\n",emp.getMid(),emp.getName(),emp.getEmailId(),emp.getDateOfJoinig(),emp.getEventsAsString());
		}
	}

	private static int getUserInput() {
		// TODO Auto-generated method stub
		System.out.println("\n\nEnter any of the below options");
		System.out.println("1.Register Employee for Event");
		System.out.println("2.Display all employees");
		System.out.println("0. to Exit");
		
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		
		if(i<3 && i>-1){
			return i;
		}
		else {
			System.out.println("Invalid Selection");
			getUserInput();
		}
		return 0;
	}
	
	private static Employee getEmpInput() throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Employee emp = null;

		System.out.println("Enter MID");
		String mid = scan.nextLine();
		emp = service.getEmpByMID(mid);
		
		if(emp == null){
			emp = new Employee();
			emp.setMid(mid);
		}else{
			return emp;
		}
		System.out.println("Enter Name");
		emp.setName(scan.nextLine());
				
		System.out.println("Enter email Id");
		emp.setEmailId(scan.nextLine());
		
		System.out.println("Enter Date in MM/DD/YYYY");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
		emp.setDateOfJoinig(sdf.parse(scan.nextLine()));
		
		return emp;
	}
	
	private static Event getEventInput() throws ParseException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		Event event = null;

		System.out.println("Enter event title");
		String title = scan.nextLine();
		event = service.getEventByTitle(title);
		if (event == null) {
			event = new Event();
			event.setTitle(title);
		} else
			return event;

		System.out.println("Enter Description");
		event.setDescription(scan.nextLine());

		return event;
	}
	
}
