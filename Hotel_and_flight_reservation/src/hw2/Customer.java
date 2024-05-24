package hw2;
/**
 * Represents a customer who can make reservations and manage their balance.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class Customer {
private String name;
private int balance;
private Basket howManyReservations;
/**
 * Constructs a customer with the given name and initial balance.
 *
 * @param name     The name of the customer.
 * @param balance  The initial balance of the customer.
 */
public Customer(String name,int balance) {
	this.name=name.toLowerCase();
	this.balance=balance;
	howManyReservations=new Basket();
}
/**
 * Gets the name of the customer.
 *
 * @return The name of the customer.
 */
public String getName() {
	return name;
	
}
/**
 * Gets the balance of the customer.
 *
 * @return The balance of the customer.
 */
public int getBalance() {
	return balance;
}
/**
 * Gets the basket of reservations of the customer.
 *
 * @return The basket of reservations.
 */
public Basket  getBasket() {
	return howManyReservations;
}
/**
 * Adds funds to the customer's balance.
 *
 * @param increment The amount to add to the balance.
 * @return The updated balance.
 * @throws IllegalArgumentException if the increment is negative.
 */
public int addFunds(int ingriment) {
	if(ingriment<0) 
		throw new IllegalArgumentException("Negative number!!!");
	this.balance+=ingriment;
	return this.balance;
	
}
/**
 * Adds a reservation to the customer's basket.
 *
 * @param request The reservation to add.
 * @return The total number of reservations in the basket.
 * @throws IllegalArgumentException if the reservation does not belong to this customer.
 */
public int  addToBasket(Reservation request) {
	boolean find=false;
		if(request.reservationName().equals(this.name)) 
			find=true;
	
	if(!find)
		throw new IllegalArgumentException("Can't find name!!!");
	
	 howManyReservations.add(request);
	 return howManyReservations.getNumOfReservations();		
}
/**
 * Adds a hotel reservation to the customer's basket.
 *
 * @param hotel     The hotel for the reservation.
 * @param type      The type of room for the reservation.
 * @param nights    The number of nights for the reservation.
 * @param breakfast Indicates whether breakfast is included in the reservation.
 * @return The total number of reservations in the basket.
 */
public int addToBasket(Hotel hotel,String type,int nights,boolean breakfast) {
	if(!breakfast) {
		HotelReservation request = new HotelReservation(this.name,hotel,type,nights);
	 howManyReservations.add(request);
	}
	else {
		 BnBReservation request = new  BnBReservation(this.name,hotel,type,nights);
	 howManyReservations.add(request);
	}
	return 	howManyReservations.getNumOfReservations();
}
/**
 * Adds a flight reservation to the customer's basket.
 *
 * @param departure The departure airport.
 * @param arrival   The arrival airport.
 * @return The total number of reservations in the basket.
 */
public int  addToBasket(Airport departure,Airport arrival) {
	FlightReservation request = new FlightReservation (this.name,departure,arrival);
	 howManyReservations.add(request);
	 return howManyReservations.getNumOfReservations();
}
/**
 * Removes a reservation from the customer's basket.
 *
 * @param request The reservation to remove.
 * @return True if the reservation is successfully removed, false otherwise.
 */
public boolean removeFromBasket(Reservation request) {
	boolean didYouRemove=howManyReservations.remove(request);
	if(didYouRemove)
		return true;
	return false;
}
/**
 * Checks out the customer, deducting the total cost of reservations from the balance.
 *
 * @return The remaining balance after checkout.
 * @throws IllegalArgumentException if the final cost exceeds the balance.
 */
public int  checkOut() {
	int finalCost=howManyReservations.getTotalCost();
	
	if(finalCost>balance)
		throw new IllegalStateException("OUT OF LUCK!!!");
	this.balance-=finalCost;
	howManyReservations.clear();
	return this.balance;
}
}
