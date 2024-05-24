package hw2;
/**
 * Represents a basket containing reservations.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class Basket {
private Reservation[] list;
/**
 * Constructs an empty basket.
 */
public Basket() {
	list = new Reservation[0];
}
/**
 * Retrieves a copy of the list of reservations in the basket.
 *
 * @return A copy of the list of reservations.
 */
public Reservation[] getProducts() {
	Reservation[] copyList = new Reservation[this.list.length];
	for(int i=0;i<this.list.length;i++)
		copyList[i] = this.list[i];
	
	return copyList;
}
/**
 * Adds a reservation to the basket.
 *
 * @param request The reservation to be added.
 * @return The number of reservations in the basket after adding.
 */
public int add(Reservation request) {
	
	 Reservation[] temp = new Reservation[this.list.length + 1];
     for (int i = 0; i < this.list.length; i++)
         temp[i] = this.list[i];

     temp[this.list.length] = request;

     this.list = temp;

	return list.length;
}
/**
 * Removes a reservation from the basket.
 *
 * @param request The reservation to be removed.
 * @return True if the reservation was successfully removed, false otherwise.
 */
public boolean remove(Reservation request) {
	int remove=-1;
	for(int i=0;i<this.list.length;i++)
		if(this.list[i].equals(request)) {
			remove=i;
	break;
		}
	
	if(remove==-1)
		return false;
	
	Reservation[] updatedList = new Reservation[this.list.length-1];
	int k=0;
	for(int i=0;i<this.list.length;i++)
		if(remove==i)
			continue;
			else {
		updatedList[k]=list[i];
	k++;
		}
	this.list=new Reservation[updatedList.length];
	
	for(int i=0;i<updatedList.length;i++)
		this.list[i]=updatedList[i];
	
	return true;
	
}
/**
 * Clears all reservations from the basket.
 */
public void clear() {
	this.list=new Reservation[0];
}
/**
 * Retrieves the number of reservations in the basket.
 *
 * @return The number of reservations in the basket.
 */
public int getNumOfReservations() {
	return this.list.length;
}
/**
 * Calculates the total cost of all reservations in the basket.
 *
 * @return The total cost of all reservations.
 */
public int getTotalCost() {
	int sum=0;
	for(int i=0;i<this.list.length;i++)
		sum+=this.list[i].getCost();
	return sum;
}

}