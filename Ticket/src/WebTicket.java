public class WebTicket extends Ticket{
	private int days;
	
	public WebTicket(int days){
		this.days = days;
		int price = SetPrice(getDays());
		super.price = price;
	}

	public int getDays(){
		return days;
	}

	public int SetPrice(int days){
		int p = 0;
		if(days >= 7){
			p = 30;
		}
		else{
			p = 40;
		}
		return p;
	}
}