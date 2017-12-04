package CMS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Complainer extends Person  implements Login   {

	Scanner s  = new Scanner(System.in);
	ArrayList<Complain> Mycomplains;
	ArrayList<Integer> ids = new ArrayList<Integer>();
	String responsefile = "Responses";
	String complainfile = "Complain";
	ObjectInputStream os;
	FileInputStream fs;
	ObjectOutputStream oo;
	
 
	
	
	public void Complain(int id) throws IOException, ClassNotFoundException
	{
		ArrayList<Complain> com ;
		Complain aaa = new Complain();
		try
		{
		ids.add(id);
		aaa.Name = name;
		System.out.print("Enter Subject Of Complain  : ");
		aaa.subject = s.nextLine();
		System.out.println("Enter Your Complain");
		aaa.Complain = s.nextLine();
		os = new ObjectInputStream(new FileInputStream(name+"MyComplains"));
		Mycomplains = (ArrayList<Complain>)os.readObject();
		Mycomplains.add(aaa);
		os.close();
		os = new ObjectInputStream(new FileInputStream(complainfile));
		 com = (ArrayList<Complain>)os.readObject();
		com.add(aaa);
		os.close();
		}
		catch(FileNotFoundException F)
		{
			Mycomplains = new ArrayList<Complain>();
			Mycomplains.add(aaa);
			com = new ArrayList<Complain>();
			com.add(aaa);
			
		}
		
		oo = new ObjectOutputStream(new FileOutputStream(name + "MyComplains"));
		oo.writeObject(Mycomplains);
		oo.close();
		oo = new ObjectOutputStream(new FileOutputStream(complainfile));
		oo.writeObject(com);
		oo.close();
	}
	
	public void ViewResponse() throws IOException, ClassNotFoundException
	{
		ArrayList<Response> responses ;
		os = new ObjectInputStream(fs = new FileInputStream(name + responsefile));
		responses = (ArrayList<Response>)os.readObject();
		for (int i = 0; i < responses.size(); i++) {
			
			
			System.out.println(responses.get(i).id);
			System.out.println(responses.get(i).ResponserName);
			if(responses.get(i).isrejected)
			{
				System.out.println("Your Complain has been rejected");
			}
			else
			{
				System.out.println("Your Complain has been Accepted");
				System.out.println(responses.get(i).Response);
				System.out.println(responses.get(i).progress);
				
			}	
		}
	}
	
	public void Cancel(int id) throws IOException,ClassNotFoundException
	{
		ArrayList<Response> responses ;
		
		os = new ObjectInputStream(fs = new FileInputStream(name + "MyComplains"));
		Mycomplains = (ArrayList<Complain>)os.readObject();
		os.close();
		os = new ObjectInputStream(new FileInputStream(complainfile));
		ArrayList<Complain> com =(ArrayList<Complain>) os.readObject();
		os.close();
		for (int i = 0; i < Mycomplains.size(); i++) {
			if(Mycomplains.get(i).id == id ){
			com.remove(Mycomplains.get(i));
				
				com.remove(i);
				break;
			}
			
		}
		
		oo = new ObjectOutputStream(new FileOutputStream( name + "MyComplains"));
		oo.writeObject(Mycomplains);
		oo.close();
		oo = new ObjectOutputStream(new FileOutputStream(complainfile));
		oo.writeObject(com);
		oo.close();
				
		}
//-----------------------------
	
	public boolean login(String Uname,String Pass) throws IOException {
		
		try {
			FileReader fr = new FileReader("Members");
			BufferedReader bf = new BufferedReader(fr);
			while(true)
			{
				String name = bf.readLine();
				String pass = bf.readLine();
				this.name=name;
				if(name == "" || name == null)
				{
					break;
				}
				if(Uname.equals(name) && Pass.equals(pass))
				{

					bf.close();
					fr.close();
					return true;
				}
				
			}
			bf.close();
			fr.close();
			return false;
			
		} catch (FileNotFoundException e) {
			return false;
		}
		
		
	}
		
	}
	



