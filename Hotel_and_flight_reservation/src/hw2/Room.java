package hw2;
/**
 * Represents a hotel room.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */
public class Room {
private String type;
private int price;
private boolean available;
/**
 * Constructs a room of the given type.
 *
 * @param givenType The type of the room.
 * @throws IllegalArgumentException if the specified room type is invalid.
 */
public Room(String givenType) {
	String LowerCaseGivenType=givenType.toLowerCase();
	if(!LowerCaseGivenType.equals("double")&&!LowerCaseGivenType.equals("queen")&&!LowerCaseGivenType.equals("king"))
		throw new IllegalArgumentException("Can't create that specific type of room!!!");
else {
	this.type=LowerCaseGivenType;
	if(this.type.equals("double"))
		this.price=9000;
	else if(this.type.equals("queen"))
		this.price=11000;
	else
		this.price=15000;
	
 this.available=true;
}
}
/**
 * Constructs a room by copying another room.
 *
 * @param room The room to copy.
 */
public Room(Room room) {
	this.type=room.type;
	this.price=room.price;
	this.available=room.available;
}
/**
 * Retrieves the type of the room.
 *
 * @return The type of the room.
 */
public String getType() {
	return this.type;
}
/**
 * Retrieves the price of the room.
 *
 * @return The price of the room.
 */
public int getPrice() {
	return this.price;
}
/**
 * Changes the availability status of the room.
 */
public void changeAvailability() {
	this.available=!this.available;
}
/**
 * Finds an available room of the specified type from the given array of rooms.
 *
 * @param rooms The array of rooms to search.
 * @param type  The type of room to find.
 * @return An available room of the specified type, or null if none is found.
 */
public static Room findAvailableRoom(Room[] rooms,String type) {
	for(int i=0;i<rooms.length;i++) 
		if(rooms[i].type.equals(type)&&rooms[i].available==true)
			return rooms[i];
	return null;
	
}
/**
 * Makes an unavailable room of the specified type available again in the given array of rooms.
 *
 * @param rooms The array of rooms to search.
 * @param type  The type of room to make available.
 * @return True if a room of the specified type is found and made available, false otherwise.
 */
public static boolean makeRoomAvailable(Room[] rooms,String type) {
	for(int i=0;i<rooms.length;i++) 
		if(rooms[i].type.equals(type)&&rooms[i].available==false) {
		rooms[i].available=true;
	return true;
		}
	return false;
	
}
}
