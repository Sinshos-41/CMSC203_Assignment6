package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Manages all orders. Handles order creation, alcohol limit enforcement, beverage 
 * processing, sorting, and monthly sale reporting. Implements BevShopInterface.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
import java.util.ArrayList;
import java.util.Collections;

//Data manager class for the beverage shop. Manages customer orders, alcohol limits, and monthly sales.
public class BevShop implements BevShopInterface {
 private int numAlcoholDrinks;
 private ArrayList<Order> orders;
 private Order currentOrder;

 public BevShop() {
     orders = new ArrayList<>();
     numAlcoholDrinks = 0;
 }

 @Override
 public boolean isValidTime(int time) {
     return time >= MIN_TIME && time <= MAX_TIME;
 }

 @Override
 public int getMaxNumOfFruits() {
     return MAX_FRUIT;
 }

 @Override
 public int getMinAgeForAlcohol() {
     return MIN_AGE_FOR_ALCOHOL;
 }

 @Override
 public boolean isMaxFruit(int numOfFruits) {
     return numOfFruits > MAX_FRUIT;
 }

 @Override
 public int getMaxOrderForAlcohol() {
     return MAX_ORDER_FOR_ALCOHOL;
 }

 @Override
 public boolean isEligibleForMore() {
     return numAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
 }

 @Override
 public int getNumOfAlcoholDrink() {
     return numAlcoholDrinks;
 }

 @Override
 public boolean isValidAge(int age) {
     return age >= MIN_AGE_FOR_ALCOHOL;
 }

 @Override
 public void startNewOrder(int time, Day day, String customerName, int customerAge) {
     currentOrder = new Order(time, day, new Customer(customerName, customerAge));
     orders.add(currentOrder);
     numAlcoholDrinks = 0;
 }

 @Override
 public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
     currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
 }

 @Override
 public void processAlcoholOrder(String bevName, Size size) {
     if (isEligibleForMore()) {
         currentOrder.addNewBeverage(bevName, size);
         numAlcoholDrinks++;
     }
 }

 @Override
 public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
     currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
 }

 @Override
 public int findOrder(int orderNo) {
     for (int i = 0; i < orders.size(); i++) {
         if (orders.get(i).getOrderNo() == orderNo) return i;
     }
     return -1;
 }

 @Override
 public double totalOrderPrice(int orderNo) {
     int index = findOrder(orderNo);
     return index >= 0 ? orders.get(index).calcOrderTotal() : 0.0;
 }

 @Override
 public double totalMonthlySale() {
     double total = 0;
     for (Order order : orders) {
         total += order.calcOrderTotal();
     }
     return total;
 }

 @Override
 public int totalNumOfMonthlyOrders() {
     return orders.size();
 }

 @Override
 public Order getCurrentOrder() {
     return currentOrder;
 }

 @Override
 public Order getOrderAtIndex(int index) {
     return (index >= 0 && index < orders.size()) ? orders.get(index) : null;
 }

 @Override
 public void sortOrders() {
     for (int i = 0; i < orders.size() - 1; i++) {
         int minIdx = i;
         for (int j = i + 1; j < orders.size(); j++) {
             if (orders.get(j).getOrderNo() < orders.get(minIdx).getOrderNo()) {
                 minIdx = j;
             }
         }
         Collections.swap(orders, i, minIdx);
     }
 }

 @Override
 public String toString() {
     StringBuilder sb = new StringBuilder();
     for (Order order : orders) {
         sb.append(order.toString()).append("\n");
     }
     sb.append("Total Monthly Sale: ").append(totalMonthlySale());
     return sb.toString();
 }
}
