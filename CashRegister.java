
public class CashRegister {
	private int cashOnHand;
	
	public CashRegister() {
		this.cashOnHand = 500;
	}
	
	public CashRegister(int cashIn) {
		this.cashOnHand = cashIn;
	}
	
	public int getCurrentBalance() {
		return cashOnHand;
	}
	
	public void acceptAmount(int amountIn){
		this.cashOnHand = this.cashOnHand + amountIn;
	}	
}
