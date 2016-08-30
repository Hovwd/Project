import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class User {
private String name;
private final long id;
private String password;
private List<User> friendlist;
private  List<String> numberlist;
private User(String name,String Password)
{
	friendlist = new ArrayList<User>();
	List<String> numberlist =new ArrayList<String>();
	Random rnd = new Random();
	id=Math.abs(rnd.nextLong());
	this.password=password;
	this.name=name;
	}
public String getName(){return this.name;}

static User createUser(String name,String password)
{
	return new User(name,password);
	}
public void addFriend(String name) throws Exception
{



	if(Server.getUser(name)==null || Server.getUser(name).getName()==this.name)
	{
		throw new Exception();
	}
	else
	{
		System.out.println("qngrutlations to new friend");
		friendlist.add(Server.getUser(name));
	}
	
}
public void addNumber(String number)
{
	numberlist.add(number);
	System.out.println("you are add Number");
	
	}
@Override
public boolean equals(Object us)
{ 
	
	if (us == null) return false;
if (us == this) return true;
if (!(us instanceof User))return false;
User otheruser = (User)us;
	return (this.name==otheruser.name && this.password==otheruser.password);
			}
public void showFriendNumbers()
{
	for(int i=0;i<friendlist.size(); i++)
	{
		System.out.println(friendlist.get(i).getName());
		for(int j=0;j<friendlist.get(i).numberlist.size();j++)
		{
			System.out.println(numberlist.get(j));
		}
		}
	}
public void showMyNumbers()
{

		for(int j=0;j<numberlist.size();j++)
		{
			System.out.println(numberlist.get(j));
		}
		
	}
}
