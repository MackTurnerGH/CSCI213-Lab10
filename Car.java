public class Car extends Vehicle {
	
	private int doors;
	private int passengers;
	
	public Car(String aMake, String aModel, String aPlate, int numDoors,
	int numPassengers) {
		super(aMake, aModel, aPlate);
		this.doors = numDoors;
		this.passengers = numPassengers;
	}
	
	public int getDoors() {
		return this.doors;
	}
	
	public int getPassengers() {
		return this.passengers;
	}
	
	@Override
	public String toString() {
		String s = String.format("%d-door %s %s with license %s",
		this.getDoors(), this.getMake(), this.getModel(), this.getPlate());
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car other = (Car) obj;
			if (this.getDoors() == other.getDoors()) {
				if (this.getPassengers() == other.getPassengers()) {
					return super.equals(other);
				}
			}
		}
		return false;
	}
	
	public Car copy() {
		String theMake = this.getMake();
		String theModel = this.getModel();
		String thePlate = this.getPlate();
		int numDoors = this.getDoors();
		int numPassengers = this.getPassengers();
		return new Car(theMake, theModel, thePlate, numDoors, numPassengers);
	}
	
	public static void main(String[] args) {
		Car myCar = new Car("Toyota", "Highlander", "ASD-2010", 4, 6);
		Car neighborCar = new Car("Nissan", "Rogue", "500MILES", 2, 4);
		Car friendCar = new Car("Subaru", "Outback", "7890-JKL", 4, 8);
		
		System.out.println(myCar + " seats " + myCar.getPassengers());
		System.out.println(neighborCar + " seats " + neighborCar.getPassengers());
		System.out.println(friendCar + " seats " + friendCar.getPassengers());
		
		Car copyCar = myCar.copy();
		System.out.println(copyCar + " seats " + copyCar.getPassengers());
	}
}