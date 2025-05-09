package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Manages a list of beverages for a single customer order. 
 * Includes time, day, customer info, and methods to add beverages (overloaded). Implements 
 * Comparable and includes total calculation logic and a custom toString().
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
import java.util.ArrayList;
import java.util.Random;

//Represents a customer's beverage order. Implements OrderInterface and Comparable.
public class Order implements OrderInterface, Comparable<Order> {

    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

 //Constructor to initialize an Order object.
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

 //Generates a random order number between 10000 and 90000.
    private int generateOrderNumber() {
        return new Random().nextInt(80001) + 10000;
    }

 //Adds a new Coffee beverage to the order.
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

 //Adds a new Alcohol beverage to the order.
    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

 //Adds a new Smoothie beverage to the order.
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

//Checks if the order was placed on a weekend.
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

 //Returns the beverage at a given index (shallow copy).
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

 //Returns the number of beverages of a specific type.
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }
        return count;
    }

 //Calculates the total price of all beverages in the order.
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }

 //Compares this order with another based on order number.
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

//Returns a deep copy of the customer associated with this order.
    public Customer getCustomer() {
        return new Customer(customer);
    }

//Returns the number of beverages in the order.
    public int getTotalItems() {
        return beverages.size();
    }

//Returns the entire beverage list (for driver use).
    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

//String representation of the order, including all beverage info.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay)
          .append("\nCustomer: ").append(customer.toString())
          .append("\nBeverages:\n");

        for (Beverage b : beverages) {
            sb.append(b.toString()).append("\n");
        }

        sb.append("Total Price: ").append(calcOrderTotal());
        return sb.toString();
    }
}
