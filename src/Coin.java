
public class Coin {

	private String name;
	private double value;
	private double amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n" + name + "\nAmount: " + amount;
	}
	
	
	
}
