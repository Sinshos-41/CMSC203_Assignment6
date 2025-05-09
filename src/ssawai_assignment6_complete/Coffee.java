package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Models a coffee drink, including options for extra shot and syrup. Overrides calcPrice() to include extra charges and provides a detailed toString().
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/

//Represents a Coffee beverage.
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public static final double SHOT_COST = 0.5;
    public static final double SYRUP_COST = 0.5;

//Constructs a Coffee object using the given values.
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

//Calculates the price of the coffee based on size and extras.
    @Override
    public double calcPrice() {
        double price = getBasePrice() + addSizePrice();
        if (extraShot) price += SHOT_COST;
        if (extraSyrup) price += SYRUP_COST;
        return price;
    }

//Returns whether the coffee has an extra shot.
    public boolean getExtraShot() {
        return extraShot;
    }

//Returns whether the coffee has extra syrup.
    public boolean getExtraSyrup() {
        return extraSyrup;
    }

//Returns a string representation of the Coffee.
    @Override
    public String toString() {
        return getBevName() + ", " + getSize() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", Price: " + calcPrice();
    }

//Checks equality between two Coffee objects.
    @Override
    public boolean equals(Object anotherBev) {
        if (!super.equals(anotherBev)) return false;
        if (!(anotherBev instanceof Coffee)) return false;
        Coffee other = (Coffee) anotherBev;
        return this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}