public class Food extends Item{//An extension of the item that focuses on the healing for the person
	private int health; 
	
	public Food(String name, double weight, int health){//Sets the name, weight, and health of the item 
		super(name, weight);
		setHealth(health);
	}

	public int getHealth(){//Gets the healing ability of the item
		return health;
	}

	public void setHealth(int health){//Sets the healing ability of the item
		this.health = health;
	}

	public String toString(){//Returns the inherited name, weight and Healing of the item
		return super.toString() + 
			   "\nHealth: " + getHealth() + "\n";
	}

	public boolean use(Object target)//Method that returns a report if the item is used successfully 
	{
		if(target instanceof Person)//Checks if the object target is a Person 
		{
			boolean r;
			Person p = (Person) target;//Gets the object Person based from the variable target
			boolean a = p.heal(getHealth());///Calls and increases the current health of the person based on the input damage of the item
			//If and else statements that checks if the person can be healed by the item or not
			if(a){
				/*If used successfully then it
				returns the healing report.*/
				System.out.println(
					p.getName() + " ate " + 
					getName() + " for " + getHealth() + " health!"
					);
				r = true;
			}
			else{//Else it reports the person cannot be healted
				System.out.println(
				p.getName() + " cannot be healed!");
				r = false;
			}
			return r;//Returns what is the action of the item to the person
		}
		else{//If the object target is not a person then it returns false
			return false;
		}
	}
}