package hw2;
/**
 * Represents a hotel reservation.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class HotelReservation extends Reservation {
private Hotel hotel;
private String type;
private int nights;
private int feeForAnight;
/**
 * Constructs a hotel reservation with the given client, hotel, room type, and number of nights.
 *
 * @param client The client's name.
 * @param hotel  The hotel for the reservation.
 * @param type   The type of room.
 * @param nights The number of nights for the reservation.
 */
public HotelReservation(String client,Hotel hotel,String type,int nights) {
	super(client);
	this.type=type.toLowerCase();
	if(hotel.reserveRoom(this.type)!=0) {
		this.hotel=hotel;
		this.nights=nights;
		
		if(this.type.equals("double")) 
			feeForAnight=9000;
		
		else  if(this.type.equals("queen")) 
			feeForAnight=11000;
		
		else
			feeForAnight=15000;
		
}
   }
/**
 * Retrieves the number of nights for the hotel reservation.
 *
 * @return The number of nights for the reservation.
 */
public int getNumOfNights() {
	return this.nights;
}
/**
 * Calculates the cost of the hotel reservation.
 *
 * @return The cost of the hotel reservation.
 */
public int getCost() {
return feeForAnight *this.nights;
}
/**
 * Checks if this hotel reservation is equal to another object.
 *
 * @param obj The object to compare.
 * @return True if the hotel reservations are equal, false otherwise.
 */

public boolean equals(Object obj) {
	if(obj==null)
		return false;
	if(this.getClass()!=obj.getClass())
		return false;
	HotelReservation otherHotelReservation=(HotelReservation) obj;
	
	boolean areNamesTheSame=this.reservationName().equals(otherHotelReservation.reservationName());
	boolean areTypeTheSame=this.type.equals(otherHotelReservation.type);
	boolean areNightsTheSame=this.nights==otherHotelReservation.nights;
	boolean areCostTheSame=this.getCost()==otherHotelReservation.getCost();
	boolean areHotelsSame=this.hotel==otherHotelReservation.hotel;
	if(areNamesTheSame&&areTypeTheSame&&areNightsTheSame&&areCostTheSame&&areHotelsSame)
		return true;
	return false;
	
}
}
