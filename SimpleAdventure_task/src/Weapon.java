public class Weapon extends Item{//An extension of the item that focuses on the damage for the person
	private int Damage; 
	
	public Weapon(String name, double weight, int damage){//Sets the name, weight, and damage of the item 
		super(name, weight);
		setDamage(damage);
	}
	public int getDamage(){//Gets the damage of the item
		return Damage;
	}

	public void setDamage(int damage){//Sets the damage of the item 
		this.Damage = damage;
	}

	public String toString(){//Returns the inherited name, weight and Damage of the item
		return super.toString() + 
			   "\nDamage: " + getDamage() + "\n";
	}

	public boolean use(Object target)//Method that returns a report if the item is used successfully 
	{
		if(target instanceof Person)//Checks if the object target is a Person 
		{
			boolean r;
			Person p = (Person) target;//Gets the object Person based from the variable target
			boolean a = p.defends(getDamage());//Calls and decreases the current health of the person based on the input damage of the item

			//If and else statements that checks if the person is dead from the attack 
			if(a){
				/*If used successfully and the peson is still alive then it 
				returns the damage report.*/
				System.out.println("Attack " + p.getName() + " with " + getName() + " for " + getDamage() + " damage!");
				r = true;
			}
			else{//Else the person is dead
				System.out.println(
				p.getName() + " is dead!");
				r = false;
			}
			return r;//Returns if the person is alive or not 
		}
		
		else{//If the object target is not a person then it returns false
			return false;
		}
	}

}