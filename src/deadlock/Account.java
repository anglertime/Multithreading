package deadlock;

public class Account {
	private int bal = 1000;
	
	public void deposit(int amt) {
		bal += amt;
	}
	
	public void withdraw(int amt) {
		bal -= amt;
	}
	
	public int getBalance() {
		return bal;
	}
	
	public static void transfer(Account acc1, Account acc2, int amt) {
		acc1.withdraw(amt);
		acc2.deposit(amt);
	}
}
