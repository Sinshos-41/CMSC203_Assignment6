package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Represents an alcoholic beverage, with an additional weekend surcharge. Overrides calcPrice() and includes a boolean to indicate if it’s a weekend drink.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/


//Represents an Alcohol beverage.
public class Alcohol extends Beverage {
    private boolean isWeekend;
    public static final double WEEKEND_COST = 0.6;
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    
//Calculates the price of the alcohol drink including any weekend surcharge.
    @Override
    public double calcPrice() {
        double price = getBasePrice() + addSizePrice();
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        return price;
    }


//Returns a string representation of this Alcohol beverage.

    @Override
    public String toString() {
        return getBevName() + ", " + getSize() + ", Weekend: " + isWeekend + ", Price: " + calcPrice();
    }

 
//Checks if this Alcohol beverage equals another.

    @Override
    public boolean equals(Object anotherBev) {
        if (!super.equals(anotherBev)) return false;
        if (!(anotherBev instanceof Alcohol)) return false;
        Alcohol other = (Alcohol) anotherBev;
        return this.isWeekend == other.isWeekend;
    }

//Indicates whether this drink is offered during the weekend.

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }
}
