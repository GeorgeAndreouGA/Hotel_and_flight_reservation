package hw2;
/**
 * Represents a bed and breakfast reservation, a type of hotel reservation.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class BnBReservation extends HotelReservation{
	/**
     * Constructs a bed and breakfast reservation with the given client, hotel, room type, and number of nights.
     *
     * @param client The client's name.
     * @param hotel  The hotel for the reservation.
     * @param type   The type of room.
     * @param nights The number of nights for the reservation.
     */
public BnBReservation(String client,Hotel hotel,String type,int nights) {
	super(client,hotel,type,nights);
}
/**
 * Calculates the total cost of the bed and breakfast reservation.
 *
 * @return The total cost of the bed and breakfast reservation.
 */
public int  getCost() {
return (super.getNumOfNights()*1000)+(super.getCost());
}
}
