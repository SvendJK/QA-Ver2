package com.svend.planes;

import java.util.Scanner;

import com.svend.planes.controller.FlightScheduleController;
import com.svend.planes.controller.PlanesController;
import com.svend.planes.domain.FlightSchedule;
import com.svend.planes.domain.Planes;

public class Choice {

	private static Scanner sc = new Scanner(System.in);
	Planes pla = new Planes();

	public String getInput() {
		System.out.println("Enter CRUD choice! To see a list of choices, please type list: ");
		return sc.nextLine();
		
	}
	public int getDBChoice() {
		System.out.println("Enter choice of database: 1 for planes, 2 for flight schedule");
		int result = sc.nextInt();
		
		return result;
	}

	public void options() {
		// create an instance of the CRUD queries class to open the connection
		PlanesController q = new PlanesController();
		FlightScheduleController f = new FlightScheduleController();

		// Ask for user input on the CRUD choice in the getInput method and store the
		// result in the "crud" variable
		String crud = getInput();
		int dbChoice;
		// try-finally block so the finally block can close the connection
		try {
			// do-while loop to start the loop and present the options to interact with the
			// database
			do {
				// switch case to match which CRUD operation to perform
				switch (crud.toLowerCase()) {
				
				
				case "create":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
					System.out.println("Do not worry about entering an ID, they are auto allocated.");
					System.out.println("Enter company: ");
					String com = sc.nextLine();
					System.out.println("Enter stand: ");
					int stand = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter colour: ");
					String colour = sc.nextLine();
					
					q.create(new Planes(com, stand, colour));
					}
					else if (dbChoice==2) {
						System.out.println("WIP");
						System.out.println("Do not worry about entering an ID, they are auto allocated.");
						System.out.println("Enter company: ");
						String com = sc.nextLine();
						System.out.println("Enter Runway: ");
						int stand = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter estimated takeoff time: ");
						String takeofftime = sc.nextLine();
						
						f.create(new FlightSchedule(com, stand, takeofftime));
						
						
					} else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					} 
					break;
				
				
				
				case "read":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
					q.read();
					} else if (dbChoice ==2) {
						f.read();
					}else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					}
					break;
				
				
				
				case "update":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
						System.out.println("Enter id of record to update: ");
						int uid = sc.nextInt();
						sc.nextLine();//capture enter key
						System.out.println("Enter the new colour of the aircraft: ");
						String nColour = sc.nextLine();
						q.update(new Planes (uid, null,0, nColour));	
					} else if (dbChoice ==2) {
						System.out.println("Enter id of record to update: ");
						int uid = sc.nextInt();
						sc.nextLine();//capture enter key
						System.out.println("Enter the new estimate time of departure of the aircraft: ");
						String nDep = sc.nextLine();
						f.update(new FlightSchedule (uid, nDep));	
					
					} else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					}
					break;
				
				
				
				
				case "delete":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
						System.out.println("Enter id of record to delete: ");
						int id = sc.nextInt();
						sc.nextLine();//capture enter key
						q.delete(new Planes (id));
					
					} else if (dbChoice ==2) {
						System.out.println("Enter id of record to delete: ");
						int id = sc.nextInt();
						sc.nextLine();//capture enter key
						f.delete(new FlightSchedule (id));
						
						
						
					}else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					}
				
					break;
				
				
				
				case "searchbyid":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
						System.out.println("Enter id of record to search: ");
						int sid = sc.nextInt();
						sc.nextLine();//capture enter key
						q.readByID(new Planes (sid));
					} else if (dbChoice ==2) {
						System.out.println("Enter id of record to search: ");
						int sid = sc.nextInt();
						sc.nextLine();//capture enter key
						f.readByID(new FlightSchedule (sid));
					
					}else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					}
					break;
					
					
					
					
				case "searchbyname":
					dbChoice = getDBChoice();
					sc.nextLine();
					if (dbChoice ==1) {
						System.out.println("Enter company name of record to search: ");
						String nameSearch = sc.nextLine();
						q.readByName(new Planes (nameSearch));
					} else if (dbChoice ==2) {
						System.out.println("Enter company name of record to search: ");
						String nameSearch = sc.nextLine();
						f.readByName(new FlightSchedule (nameSearch));
					}else {
						System.out.println("Somethings gone wrong, wrong number perhaps?");
					}
					break;
					
					
					
					
					
				case "list":
					System.out.println("create, read, update, delete, searchbyid, searchbyname");
					break;	
					
				default:
					System.out.println("Invalid CRUD choice");
				} 
				// check if user wants to continue or break out of the loop
				System.out.println("Would you like to continue? (y/n)");
				String quit = sc.nextLine();
				if (quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if (quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}

			} while (!crud.equals("quit"));
			System.out.println("Goodbye!");
		} finally {
			q.closeConn();
		}
	}

}
