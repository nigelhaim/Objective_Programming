public class Ticket{
	public int serialNumber;
	public int price; 
	public static int counter;

	public Ticket(){
		++counter;
		serialNumber = counter;
	}

	public int getPrice(){
		return price;
	}

	public int serialNumber(){
		return serialNumber;
	}
	public String toString(){
		return "Ticket: [ serial#: " + serialNumber() + " Price: " + getPrice() + "]";
	}
}