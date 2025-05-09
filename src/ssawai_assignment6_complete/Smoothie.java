package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Describes a smoothie beverage with options for number of fruits and added protein. Calculates price based on those factors and provides a custom toString().
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
//Represents a Smoothie beverage.
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    public static final double PROTEIN_COST = 1.5;
    public static final double FRUIT_COST = 0.5;

 //Constructs a Smoothie with name, size, number of fruits, and protein option.
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

 //Calculates the price of the smoothie based on size, fruits, and protein.
    @Override
    public double calcPrice() {
        double price = getBasePrice() + addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

 //Returns the number of fruits added.
    public int getNumOfFruits() {
        return numOfFruits;
    }

 //Indicates whether protein is added.
    public boolean getAddProtein() {
        return addProtein;
    }

 //Sets the number of fruits.
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

//Sets whether protein is added.
    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }

 //Returns a string representation of the Smoothie.
    @Override
    public String toString() {
        return getBevName() + ", " + getSize() + ", Protein: " + addProtein + ", Fruits: " + numOfFruits + ", Price: " + calcPrice();
    }

  //Checks equality based on name, type, size, number of fruits, and protein.
    @Override
    public boolean equals(Object anotherBev) {
        if (!super.equals(anotherBev)) return false;
        if (!(anotherBev instanceof Smoothie)) return false;
        Smoothie other = (Smoothie) anotherBev;
        return this.numOfFruits == other.numOfFruits && this.addProtein == other.addProtein;
    }
}
