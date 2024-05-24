package hw2;
/**
 * Represents a reservation.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public abstract class Reservation {
private String client;
/**
 * Constructs a reservation with the given client name.
 *
 * @param client The client's name.
 */
public Reservation(String client) {
	this.client=client.toLowerCase();
}
/**
 * Retrieves the name of the client associated with the reservation.
 *
 * @return The name of the client.
 */
public final String reservationName() {
	return this.client;
}
/**
 * Retrieves the cost of the reservation.
 *
 * @return The cost of the reservation.
 */
public abstract int getCost();
/**
 * Checks if this reservation is equal to another object.
 *
 * @param obj The object to compare.
 * @return True if the reservations are equal, false otherwise.
 */
public abstract boolean equals(Object obj);
}
