package CMS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class CompMS {
	public static int id = 1000;
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Menu();
		
	}
	
	public static void Menu() throws IOException, ClassNotFoundException
	{
		System.out.println("Login As ");
		System.out.println("1. Comaplainer");
		System.out.println("2. Handler");
		System.out.println("3 .Manager");
		
		Scanner s = new Scanner(System.in);
		String op = s.nextLine();
		
		if(op.equals("1"))
		{
			Complainer c = new Complainer();
			System.out.println("Enter Name");
			String name = s.nextLine();
			System.out.println("Enter Password");
			String pass = s.nextLine();
			
			if(c.login(name, pass))
			{
				int x =0;
				
				System.out.println(name +  "Logged In...");
				while(x!=2)
				{
				System.out.println("1. Complain");
				System.out.println("2. View Responses");
				System.out.println("3. Cancel a Complain");
				System.out.println("4. LogOut");
				
				 x = s.nextInt();
				
				
				switch(x)
				{
				case 1 :
				{
					
					c.Complain(id++);
					break;
				}
				case 2:
				{
					c.ViewResponse();
					break;
				}
				case 3 :
				{
					System.out.println("Enter ID to cancel");
					int ID = s.nextInt();
					c.Cancel(ID);
					break;
				}
				case 4:
				{
					Menu();
					break;
				}
				
				}
				
				}
			}
		}
		else if (op.equals("2")) {
			
			ComplainHandler ch = new ComplainHandler();
			System.out.println("Enter Name");
			String name = s.nextLine();
			System.out.println("Enter Password");
			String pass = s.nextLine();
			
			if(ch.login(name, pass))
			{
				int x = 0;
				while(x != 2)
				{
				System.out.println(name +  "Logged In...");
				System.out.println("1. View Complains");
				System.out.println("2. LogOut");
				
				 x = s.nextInt();
				
				
				switch(x)
				{
				case 1 :
				{
					
					ch.ReadComplains();
					break;
				}
				case 2:
				{
					Menu();
					break;
				}
				
				
				}
				
				}
			}
			
		}
		else if (op.equals("3")) {
			
			
			ComplainManager cm = new ComplainManager();
			System.out.println("Enter Name");
			String name = s.nextLine();
			System.out.println("Enter Password");
			String pass = s.nextLine();
			
			if(cm.login(name, pass))
			{
				int x = 0;
				while(x!=2)
				{
				System.out.println(name +  "Logged In...");
				System.out.println("0. Add an Accessor");
				System.out.println("1. View Complains");
				System.out.println("2. LogOut");
				
				 x = s.nextInt();
				
				
				switch(x)
				{
				
				
				case 0 :
				{
					//Abhi koi aur handler nhi hai bnawa wrna woh yahan pass hojaiga
					//cm.setSuccessor(man);
					System.out.println("Accessor Added Your Complains will be forwadded to this Manager");
					
					
					break;
				}
				case 1 :
				{
					
					cm.ReadComplains();
					break;
				}
				case 2:
				{
					Menu();
					break;
				}
				
				
				}
				
				
			}
			}
		}
		
	}
}
