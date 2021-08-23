package springBootjdbc.sbjdbc.modal;

public class BankAccountInfo {
	private long id;
	private String username;
	private double balance;
	
	public BankAccountInfo() {
	}
	
	public BankAccountInfo(long _id, String _fullName, double _balance) {
		super();
		this.id = _id;
		this.username = _fullName;
		this.balance = _balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long _id) {
		this.id = _id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String _username) {
		this.username = _username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double _balance) {
		this.balance = _balance;
	}
	
	

}
