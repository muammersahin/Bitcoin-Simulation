import java.util.HashMap;
import java.util.Map;

public class User {

	private String name;
	private String surname;
	private String email;
	private int accountNo;
	private String password;
	private String walletAddress;
	private double AvailCash;
	private Map<String, Coin> coins = new HashMap<String, Coin>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public User(String name, String surname, String email, int accountNo, String password, String walletAddress,
			double availCash, Map<String, Coin> coins) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.accountNo = accountNo;
		this.password = password;
		this.walletAddress = walletAddress;
		AvailCash = availCash;
		this.coins = coins;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "Name: " + name + "\nSurname: " + surname + "\nEmail: " + email + "\nAccount no: " + accountNo + "\nPassword: " + password + "\nWallet: " + walletAddress + "\nAvailable cash: " + AvailCash;
		out += coins.toString();
		return out;
	}
	
	
	
}
