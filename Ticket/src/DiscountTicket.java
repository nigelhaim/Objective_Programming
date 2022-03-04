public class DiscountTicket extends WebTicket
{
	private String type;

	public DiscountTicket(int days, String type){
		super(days);
		int price = SetPrice(getDays());

		this.type = type;
		super.price = SetDiscountPrice(price, getType());
	}

	public String getType(){
		return type;
	}
	
	public int SetDiscountPrice(int price, String type){
		if(type == "Student" || type == "Senior"){
			price /= 2;
		} 
		return price;	
	}
}