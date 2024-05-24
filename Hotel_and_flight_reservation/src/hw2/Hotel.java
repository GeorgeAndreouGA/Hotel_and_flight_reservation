package hw2;
/**
 * Represents a hotel.
 * **
 * Represents an airport with its coordinates and fees.
 *  @author George Andreou
* @since 16/3/24
 */

public class Hotel {
private String hotelName;
private Room[] rooms;
/**
 * Constructs a hotel with the given name and rooms.
 *
 * @param hotelName The name of the hotel.
 * @param rooms     The array of rooms in the hotel.
 */
public Hotel(String hotelName,Room[] rooms) {
	this.hotelName=hotelName.toLowerCase();
	
	this.rooms=new Room[rooms.length];
	for(int i=0;i<this.rooms.length;i++)
		this.rooms[i]=new Room(rooms[i]);
	
}
/**
 * Reserves a room of the specified type in the hotel.
 *
 * @param type The type of room to reserve.
 * @return The price of the reserved room.
 * @throws IllegalArgumentException if the specified room type is not available.
 */
public  int reserveRoom(String type) {
	Room availableRoom=Room.findAvailableRoom(this.rooms,type);
	if(availableRoom==null)
	throw new IllegalArgumentException("Can't find room!!!");
	
	availableRoom.changeAvailability();
	return availableRoom.getPrice();
}
/**
 * Cancels a room reservation of the specified type in the hotel.
 *
 * @param type The type of room to cancel.
 * @return True if the room reservation is successfully canceled, false otherwise.
 */
public boolean  cancelRoom(String type) {
	return Room.makeRoomAvailable(this.rooms, type);
}
}
