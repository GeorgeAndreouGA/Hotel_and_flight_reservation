package hw2;
/**
 * Represents a flight reservation.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class FlightReservation extends Reservation {
	private Airport departure;
	private Airport arrival;
	 /**
     * Constructs a flight reservation with the given client, departure airport, and arrival airport.
     *
     * @param client    The client's name.
     * @param departure The departure airport.
     * @param arrival   The arrival airport.
     */
	public FlightReservation(String client,Airport departure,Airport arrival) {
		super(client);
		if(Airport.getDistance(departure, arrival)==0)
			throw new IllegalArgumentException("Same Airport");
		this.departure=departure;
		this.arrival=arrival;
	}
	/**
     * Calculates the cost of the flight reservation.
     *
     * @return The cost of the flight reservation.
     */
public int getCost() {
	double fuel=fuelCost();
	int airportsFees=this.departure.getFees()+this.arrival.getFees();
	return (int)Math.ceil(fuel+airportsFees+(53.75*100));
}
/**
 * Calculates the cost of the fuel for the flight.
 *
 * @return The cost of the fuel.
 */
private double fuelCost() {
	return ((1.24*100)*Airport.getDistance(this.departure,this.arrival))/167.52;
}
/**
 * Checks if this flight reservation is equal to another object.
 *
 * @param obj The object to compare.
 * @return True if the flight reservations are equal, false otherwise.
 */
public boolean equals(Object obj) {
	if(obj==null)
		return false;
	if(this.getClass()!=obj.getClass())
		return false;
	FlightReservation otherFlightReservation=(FlightReservation) obj;
	
 boolean areNamesTheSame=this.reservationName().equals(otherFlightReservation.reservationName());
 boolean areFlightsTheSame=(this.departure==otherFlightReservation.departure)&&(this.arrival==otherFlightReservation.arrival);
 if(areNamesTheSame&& areFlightsTheSame)
	 return true;
 return false;
  }
 }
