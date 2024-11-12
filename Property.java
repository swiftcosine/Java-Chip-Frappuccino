/*
 * Class: CMSC203 
 * Instructor: Prof. Tarek
 * Description: This program is designed to manage properties for a management company. It includes classes to handle various entities like properties, plots, and the management company itself, with a graphical user interface (GUI) using JavaFX for input and output. Plot class handles the plot boundaries for each property, ensuring no overlap and proper containment within the management company's limits.
 * Due: October 29, 2024
 * Platform/compiler: Eclipse
	 * I pledge that I have completed the programming assignment independently. 
	 * I have not copied the code from a student or any source. 
	 * I have not given my code to any student.
   Print your Name here: Ash Ibasan
*/

package afour;

public class Property {
    private String city, owner, propertyName; 
    private double rentAmount;
    private Plot plot;

    // default constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
    }

    // constructor with property details only
    public Property(String propertyName, String city, double rent, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rent;
        this.owner = owner;
        this.plot = new Plot();
    }

    // constructor with property and plot details
    public Property(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rent;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property other) {
        this(other.propertyName, other.city, other.rentAmount, other.owner, other.plot.getX(), other.plot.getY(), other.plot.getWidth(), other.plot.getDepth());
    }

    // getters and setters
    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public double getRentAmount() { return rentAmount; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public Plot getPlot() { return plot; }

    // toString method
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%.1f", propertyName, city, owner, rentAmount);
    }
}