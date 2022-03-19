public class Tester{
		    
	public static void printPerson(Person p) {
        System.out.println("The health of " + p.getName()  + " is " + p.getHealth());
        System.out.println(p.getName() + (p.isAlive() ? " is alive." : " has passed on."));
        System.out.println(p);
    }

    public static void printItem(Item item) {
        System.out.println("The item " + item.getName() + " has weight " + item.getWeight());

        /*if(item instanceof Food) {
            System.out.println("It also heals " + ((Food)item).getHealth());
        }

        if(item instanceof Weapon) {
            System.out.println("It also does " + ((Weapon)item).getDamage() + " damage");
        }*/

        System.out.println(item);
    }

	public static void main(String[] args) {
		/*Person frodo = new Person("Frodo Baggins");

		printPerson(frodo);

		
		frodo.defends(110);
		printPerson(frodo);*/

		/*Item fork = new Item("Fork", 0.45);
		printItem(fork);*/

		Item taters = new Food("Taters", 0.3, 45);
		printItem(taters);
	}
}