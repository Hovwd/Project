import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Server {
 private static List<User> users;
 protected static void inUsers(){
	 users=new ArrayList();
 }
 public static List<User> getUsers()
 {
	 return users;
 }
 public static User getUser(String name)
 {
	 if(users.size()!=0 || users!=null){
	 for(int i=0;i<users.size();i++)
	 {
		 if(users.get(i).getName().equals(name))
		 {
			 return users.get(i);
 }
		 }
	 }
	return null;
	 
 }
static {
	 
	users=new ArrayList<User>();
	 String data="";
	 Gson gson=new GsonBuilder().setPrettyPrinting().create();
	 BufferedReader jsoninobj = null;
	try {
		jsoninobj = new BufferedReader(new FileReader("db.json"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		try {
			while (jsoninobj.ready()) {
				data+=jsoninobj.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		  Type type = new TypeToken<List<User>>() {
	        }.getType();
	      users = gson.fromJson(data, type);
		
 }
}
