import java.util.HashMap;
import java.util.Map;

public class UserSys {

	public static Map<Integer, User> users = new HashMap<Integer, User>();
	
	public static int AddUser(User u){
		if(users.containsValue(u.getAccountNo())){
			return 0;
		}
		else{
			users.put(u.getAccountNo(), u);
			return 1;
		}
	}
	
	public static int RemoveUser(int accountNo){
		if(users.containsKey(accountNo)){
			users.remove(accountNo);
			return 1;
		}
		else
			return 0;
	}
	
	public static User FindUser(int accountNo){
		
		if(users.containsKey(accountNo))
			return users.get(accountNo);
		else
			return null;
		
	}
}
