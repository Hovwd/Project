import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Aplication extends Server{
private boolean isonline;
public Aplication()
{
	isonline=false;
	}
private User online_user;
private void save() throws IOException{
	Gson gson=new GsonBuilder().setPrettyPrinting().create();
	String json=gson.toJson(getUsers());
	BufferedWriter jsoninfile=new BufferedWriter(new FileWriter(new File("db.json")));
	jsoninfile.write(json);
	jsoninfile.flush();
	jsoninfile.close();
}
private void signIn(){
	Scanner scan =new Scanner(System.in);
	System.out.println("Say your Nname");
	System.out.println("<<<<<");
	String name=scan.nextLine();
	System.out.println("Say your password");
	System.out.println("<<<<<");
	String password=scan.nextLine();
	User us=User.createUser(name, password);
	if(getUsers()==null || getUsers().size()==0)
	{
		System.out.println("Youser no exsint incorect login or password");
	}
	else
	{
		for(int i=0;i<getUsers().size();i++)
		{
			if(getUsers().get(i).equals(us))
			{
				online_user=getUsers().get(i);
				isonline=true;
			}
		}
	}
	if(!isonline)
	{
		System.out.println("the acount no exist");
		
	}
}
private void signUp() throws IOException{
	isonline=true;
	Scanner scan =new Scanner(System.in);
	System.out.println("Say your Nname");
	System.out.println("<<<<<");
	String name=scan.nextLine();
	System.out.println("Say your password");
	System.out.println("<<<<<");
	String password=scan.nextLine();
	User us=User.createUser(name, password);
	if(getUsers()==null || getUsers().size()==0)
	{
		
		getUsers().add(us);
		online_user=us;
		isonline=true;
		System.out.println("you are e creat new acount");
		save();
	}
	else{
		
		for(int i=0;i<getUsers().size();i++)
		{
			if(getUsers().get(i).equals(us))
			{
				
				isonline=false;
				break;
			}
			
		}
		if(isonline)
		{
			getUsers().add(us);
			online_user=us;
			isonline=true;
			System.out.println("you are e creat new acount");
			save();
		}
	}

	
}
private void signOut(){
	online_user=null;
	isonline=false;
	System.out.println("you are exitde in your acount");
}
private void pushFriend() throws IOException{
	Scanner scan =new Scanner(System.in);
	System.out.println("check your friend name");
	System.out.print("<<<<<<<");
	String name = scan.nextLine();
	try {
		online_user.addFriend(name);
	} catch (Exception e) {
		System.out.println("this user no exist");
	}
	save();
}
private void addNumber(){}
private void help(){}

private void ShowNumbers(){};
public void play() throws IOException
{
	System.out.println();
	while(true)
	{
		
		Scanner scan =new Scanner(System.in);
		String command=scan.nextLine();
		if(!isonline)
		{
			switch(command){
			case "Sign In":
			signIn();
			break;
			case "Sign Up":
				signUp();
				break;
				default:
				System.out.println("incorect usser name");
			}
			
			
		}
		else
		{
			switch(command){
			case "add friend":
				pushFriend();
			}
		}
	}
	}
}
