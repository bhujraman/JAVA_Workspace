package com.dal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;
import com.dal.exception.UserNotFoundException;
//import com.model.Employee;

public class MainClass {

	public static void main(String[] args) throws IOException 
	{

		EmployeeInterface econtol = new EmployeeController();

		Scanner sc = new Scanner(System.in);
		String Choice = null;

		try {
			String uname = null;
			String pwd = null;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader bsr = new BufferedReader(isr);
			System.out.println("Enter Username:");
			uname = bsr.readLine();
			System.out.println("Enter password:");
			pwd = bsr.readLine();

			if (uname.equals("jbh") && pwd.equals("abc")) {
				System.out.println("Welcome " + uname);
			} else {
				throw new UserNotFoundException();

			}
		}

		catch (UserNotFoundException unf) {
			System.out.println(unf);
			return;
		} finally {
			System.out.println("Finally block");
		}

		do {
			System.out.println("enter your choice");
			System.out.println(("1. Add Employee"));
			System.out.println(("2. View Employee"));
			System.out.println(("3. Serialise Employee"));
			System.out.println(("4. DeSerialise Employee"));
			System.out.println(("5. Sort By EmpId"));
			System.out.println(("6. Sort By EmpName"));
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				econtol.addEmployee();
				break;
			}

			case 2: {
				econtol.viewEmployee();
				break;
			}
			case 3: {
				econtol.serialiseemp();
				break;	
			}
			case 4: {
				econtol.deserialiseemp();
				break;
			}
			case 5: {
				econtol.sortByEmpId();
				break;
				
			}
			case 6: {
				econtol.sortByEmpName();
				break;
				
			}

			default: {
				System.out.println(("enter your choice"));
				break;
			}
			
			}
			System.out.println("Do u wanna continue? Y or n");
			Choice = sc.next();

		} while (Choice.equals("Y") || Choice.equals("y"));
		System.out.println("Exited");
		System.exit(0);
	}
	
	

}