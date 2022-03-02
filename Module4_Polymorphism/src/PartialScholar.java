public class PartialScholar extends Student{
	private float discountRate;
	private float payableAmount;
	public PartialScholar(String name, String course, float tuitionFee, float discountRate){
		super(name, course, tuitionFee);//Sets the values of the name, course, and the tuition fee of the student 
		this.discountRate = discountRate;//Sets the discountRate of the partial Scholarship 
		payableAmount = tuitionFee - (tuitionFee * discountRate);//Computes the amount to be payed 
	}

	public float getPayableAmount(){//Returns the amount to be payed with the discount 
		return payableAmount;
	}

	public String toString(){//Sets the string to be returned to the TestStudent.java
		return  "\n" + "Student # " + getStudentNumber() + " : " + getName() + " is taking up " + getCourse() + " with a tuition fee of " + getTuitionFee()
		+ "\n" + "Discount Rate of: " + discountRate * 100 + "%"
		+ "\n" + "Net Payable Tuition Fee is: " + getPayableAmount();
	}
}