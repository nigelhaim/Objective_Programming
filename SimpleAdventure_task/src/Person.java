public class Person{
	private String name;
	private int    health = 100;//Sets the default health as 100
	
	public Person(String name){//Sets the name of the person
		this.name = name;
	}

	public String getName(){//Gets the name of the person 
		return name; 
	}

	public int getHealth(){//Gets the current health of the person 
		return health;
	}

	public String toString(){//Returns the name and the health of the person
		return "Name: " + getName() + 
			   "\nHealth: " + getHealth() + "\n";
	}

	
	public boolean isAlive(){//A method that checks if the person is alive 
		boolean is_alive;//Initiates the boolean variable 
		if (getHealth() == 0){//If statement that gets the current health of the person and compares if it is equal to 0
			is_alive = false;//If the health is equal to 0 then it returns false 
		}
		else{//If the health is not equal to 0 then it returns true 
			is_alive = true;
		}
		return is_alive;
	}

	public boolean heal(int boost){//Method that heals the person based on the given value of boost 
		boolean live = false;//Initiates boolean variable as false 
		if(isAlive()){//Checks if the person is still alive 
			//If returned true then it gets the current health
			int health = getHealth();
			/*Loops and adds 1 to the health of the person if it doesn't 
			reach the required variable and the health is less than 100*/
			for(int hb = 0; (hb < boost) && (getHealth() < 100); hb++){
				this.health++;
			}
			return true;//If successfully healed then it returns true
		}
		return live;//Returns the if it successfully healed or not 
	}

	public boolean defends(int damage){//Method that decreases the current health based on the value of damage 
		int health = getHealth();//Gets the health of the character 
		for(int hd = 0; hd < damage && getHealth() > 0; hd++){
			/*Loops and subtracts 1 on the health until it reaches the value of the 
			damage and health does not reach 0*/
			this.health--;
		}
		return isAlive();//Returns if the person is still alive or not based from the current health
	}
}