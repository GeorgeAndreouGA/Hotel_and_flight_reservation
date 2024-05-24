package hw2;
/**
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class Airport {
private int x;
private int y;
private int fees;
/**
 * Constructs an airport with the given coordinates and fees.
 *
 * @param x     The x-coordinate of the airport.
 * @param y     The y-coordinate of the airport.
 * @param fees  The fees associated with the airport.
 */
public Airport (int x,int y,int fees) {
	this.x=x;
	this.y=y;
	this.fees=fees;
}
/**
 * Gets the fees associated with the airport.
 *
 * @return The fees of the airport.
 */
public int getFees() {
	return this.fees;
}
/**
 * Calculates the distance between two airports.
 *
 * @param airport1 The first airport.
 * @param airport2 The second airport.
 * @return The distance between the two airports, rounded up to the nearest integer.
 */
public static int getDistance(Airport airport1,Airport airport2) {
	double overall_x=airport1.overallX(airport2);
	double overall_y=airport1.overallY(airport2);
	return (int)Math.ceil(overall(overall_x,overall_y));
	
}

/**
 * Calculates the overall difference in x-coordinates between this airport and another airport.
 *
 * @param airport The other airport.
 * @return The overall difference in x-coordinates.
 */
private double overallX(Airport airport) {
	return Math.pow((this.x-airport.x),2);
}
/**
 * Calculates the overall difference in y-coordinates between this airport and another airport.
 *
 * @param airport The other airport.
 * @return The overall difference in y-coordinates.
 */
private double overallY(Airport airport) {
	return Math.pow((this.y-airport.y),2);
}
/**
 * Calculates the overall distance between two airports.
 *
 * @param overall_x The overall difference in x-coordinates.
 * @param overall_y The overall difference in y-coordinates.
 * @return The overall distance.
 */
private static double overall(double overall_x,double overall_y) {
	return Math.sqrt(overall_x+overall_y);
}

}
