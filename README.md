 Represents a customer who can make reservations and manage their balance.
     #Represents an airport with its coordinates and fees.
     #Represents a Hotel with its coordinates and fees.

Usage
To use the Customer class in your own project, follow these steps:
Create a new Customer object:
Customer customer = new Customer("John", 100);

Use the available methods to manage the customer's reservations and balance:
customer.addFunds(50);
customer.addToBasket(hotel, "Standard", 3, true);
customer.addToBasket(flightDeparture, flightArrival);
customer.checkOut();

Run:
Navigate to the project directory
Compile the Java files: javac *.java
