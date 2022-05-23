public class Age
{
	private int months, days, years;
	
	public Age(int days, int months, int years)
	{
		this.days = days;
		this.months = months;
		this.years = years;
	}
	
	public int getDays()
	{
		return days;
	}
	
	public int getMonths()
	{
		return months;
	}
	
	public int getYears()
	{
		return years;
	}
	
	public String toString()
	{
		return getDays() + " days, " + getMonths() + " months, " + getYears() + " years";
	}
}