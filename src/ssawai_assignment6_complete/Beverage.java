package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Represents a general beverage with a name, type, and size. It includes constants for 
 * base price and size upcharge. Contains common methods like calcPrice() (abstract), toString(), and equals().
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
//Abstract class representing a Beverage.
public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;

    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

   
//Constructs a Beverage object with the given name, type, and size.   
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }


//Calculates the additional size cost for medium and large beverages.
    public double addSizePrice() {
        switch (size) {
            case MEDIUM: return SIZE_PRICE;
            case LARGE: return 2 * SIZE_PRICE;
            default: return 0.0;
        }
    }

//Abstract method to calculate the price of the beverage.

    public abstract double calcPrice();


//Checks if two beverages are equal by comparing name, type, and size.
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) return true;
        if (anotherBev == null || getClass() != anotherBev.getClass()) return false;
        Beverage other = (Beverage) anotherBev;
        return bevName.equals(other.bevName) && type == other.type && size == other.size;
    }


//Returns a string representation of the beverage.
    @Override
    public String toString() {
        return bevName + ", " + size;
    }

//Getters and Setters
    public String getBevName() {
        return bevName;
    }

    public void setBevName(String bevName) {
        this.bevName = bevName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }
}