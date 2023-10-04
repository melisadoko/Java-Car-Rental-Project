/** The class Car will be used to create objects of type Car in the application
 * This class has two variables: type and pricePerDay
 * We have created the constructor and getters foreach of the variables
 * We have created 2 methods that display data for 2 fields
 */
public class Car {
	private String type;
	private int pricePerDay;
	
	public Car(String type,int price) {
		this.type=type;
		this.pricePerDay=price;
	}
	
	public String getType() {
		return type;
	}
	public int getPrice() {
		return pricePerDay;
	}

}
