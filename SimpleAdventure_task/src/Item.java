public class Item{//A class that will be inherited by food and weapon 
	private String name; 
	private double weight;

	public Item(String name, double weight){//Sets the name and weight of the item
		setName(name);//Calls the setter for the variable name 
		setWeight(weight);//Calls the setter for the variable weight
	}
	public String getName(){//Gets the name of the item
		return name;
	}

	public double getWeight(){//Gets the weight of the item
		return weight;
	}

	public void setName(String name){//Sets the name of the item 
		this.name = name;
	}

	public void setWeight(double weight){//Sets the weight of the item
		this.weight = weight;
	}

	public String toString(){//A method that returns the name and weight of the item
		return "Name: " + getName() + 
			   "\nWeight: " + getWeight() + "\n";
	}

	public boolean use(Object target){//If the item does not exists then it is not usable
		System.out.println("Not usable");
		return false;
	}
}