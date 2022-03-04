public class TicketTest
{
	public static void main(String args[])
	{
		int total_sales = 0;

 	       	Ticket[] tickets = {
        	        new WebTicket(10),
                	new WebTicket(5),
	                new CounterTicket(),
        	        new DiscountTicket(5, "Student"),
                	new DiscountTicket(10, "Senior"),
        	};

	        for(int i=0; i<tickets.length; i++) {
            		System.out.println( tickets[i] );
        	}

	        for(int i=0; i<tickets.length; i++) {
        		total_sales += tickets[i].getPrice();
        	}  

        	System.out.println();
        	System.out.print("Total sales: " + total_sales );


	}
}
