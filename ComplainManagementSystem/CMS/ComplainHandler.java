package CMS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class ComplainHandler extends Person implements Login,IObservable {

	public boolean login(String Uname, String Pass) throws IOException {
	
		try 
		{
		FileReader fr = new FileReader("Handlers");
		BufferedReader br = new BufferedReader(fr);
		while(true)
		{
			String name = br.readLine();
			String pass = br.readLine();
			this.name = name;
			if(name.equals("") || name.equals(null))
			{
				break;
			}
			if(Uname.equals(name) && Pass.equals(pass))
			{

				return true;
			}
			
		}
		return false;
		}
		catch(FileNotFoundException fe)
		{
			return false;
		}
		
	}
	
	public void RespondToAComplain(int id ,String Cname) throws IOException, ClassNotFoundException
	{
		ArrayList<Response> responses ;
		Response res = new Response();
		res.id = id;
		System.out.println("Accept Or Reject");
		String AR = s.nextLine();
		if(res.isrejected = (AR.equals( "Accept")))
		{
			res.progress = 0;
			res.ResponserName = name;
			res.Response = "This Compalaint is Accepted Thanks For Complaining";
		
		}
		try{
		fi = new FileInputStream(Cname + "Responses");
		oi = new ObjectInputStream(fi);
		 responses =(ArrayList<Response>) oi.readObject();
		responses.add(res);
		oi.close();
		fi.close();
		}
		catch(FileNotFoundException e)
		{}
		finally
		{
			responses = new ArrayList<Response>();
		fo = new FileOutputStream(Cname + "Responses");
		oo = new ObjectOutputStream(fo);
		oo.writeObject(responses);
		oo.close();
		fo.close();
		}
				
	}
	
	Scanner s = new Scanner(System.in);
	FileInputStream fi;
	FileOutputStream fo;
	ObjectInputStream oi;
	ObjectOutputStream oo;
	
	@SuppressWarnings("unchecked")
	public void ReadComplains() throws IOException, ClassNotFoundException{
	
		fi = new FileInputStream("Complain");
		oi = new ObjectInputStream(fi);
		
		ArrayList<Complain> complain = (ArrayList<Complain>)oi.readObject();
		oi.close();
		fi.close();
		System.out.println("There Are" + complain.size() + " complains ");
		System.out.print("You Want to Read All ? : Yes/No");
		String ans =s.nextLine();
		if(ans.equals( "Yes") || ans.equals("yes"))
		{
			for (int i = 0; i < complain.size(); i++) {
				
				if(complain.get(i).Isread == false)
				{
				System.out.println( complain.get(i).subject);
				System.out.println( complain.get(i).id);
				System.out.println( complain.get(i).Complain);
				complain.get(i).Isread = true;
				
				
				RespondToAComplain(complain.get(i).id,complain.get(i).Name);
				System.out.println("Enter name to send this complain to ? ");
				String a = s.nextLine();
				ForwardTo(a,complain.get(i));
				}
			}
			
		}
		else
		{
			System.out.println("Enter the no of Compalin To read ? ");
			int index =s.nextInt();
			System.out.println( complain.get(index).subject);
			System.out.println( complain.get(index).id);
			System.out.println( complain.get(index).Complain);
			complain.get(index).Isread = true;
			RespondToAComplain(complain.get(index).id,complain.get(index).Name);
			System.out.println("Enter name to send this complain to ? ");
			String a = s.nextLine();
			ForwardTo(a,complain.get(index));
			
		}
		fo = new FileOutputStream("Compalin");
		oo = new ObjectOutputStream(fo);
		oo.writeObject(complain);
		oo.close();
		fo.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public void ForwardTo(String name , Complain c)
	{
		ArrayList<Complain> com;
		try
		{
		fi = new FileInputStream(name);
		oi = new ObjectInputStream(fi);
		
		
		 com = (ArrayList<Complain>)oi.readObject();
		com.add(c);
		oi.close();
		fi.close();
		}
		catch (Exception e)
		{
			com = new ArrayList<Complain>();
		}
		try {
			fo = new FileOutputStream(name);
			oo = new ObjectOutputStream(fo);
			oo.writeObject(com);
			oo.close();
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Some thing went wrong...");
		}
		
		
		
	}

}

