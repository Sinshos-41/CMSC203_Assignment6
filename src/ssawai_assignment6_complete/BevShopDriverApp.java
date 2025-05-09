package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Main driver class demonstrating system functionality. Takes user input, processes orders, and prints details similar to a point-of-sale interaction.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        //First Order
        System.out.println("Start please a new order:");
        System.out.println("Your Total Order for now is 0.0");

        System.out.print("Would you please enter your name: ");
        String name1 = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int age1 = scanner.nextInt();
        scanner.nextLine();

        bevShop.startNewOrder(3, Day.SUNDAY, name1, age1);

        if (bevShop.isValidAge(age1)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Would you please add an alcohol drink");
                bevShop.processAlcoholOrder("Alcohol Drink " + i, Size.LARGE);
                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order is " + bevShop.getCurrentOrder().calcOrderTotal());
                if (!bevShop.isEligibleForMore()) {
                    System.out.println("You have a maximum alcohol drinks for this order");
                    break;
                } else {
                    System.out.println("Your current alcohol drink order is less than 4");
                }
            }
        }

        System.out.println("Would you please add a COFFEE to your order:");
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        //Second Order
        System.out.println("#------------------------------------#");
        System.out.println("Would you please start a new order");

        System.out.print("Would you please enter your name: ");
        String name2 = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int age2 = scanner.nextInt();
        scanner.nextLine();

        bevShop.startNewOrder(12, Day.MONDAY, name2, age2);
        System.out.println("The Total Price on the Order: 0.0");

        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Banana Blast", Size.MEDIUM, 3, true);
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Berry Blend", Size.SMALL, 2, false);

        System.out.println("Would you please add a COFFEE to order");
        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("Would you please add a drink");
        if (!bevShop.isValidAge(age2)) {
            System.out.println("Your Age is not appropriate for alcohol drink");
        }

        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        //Count fruits
        int totalFruits = 0;
        for (int i = 0; i < bevShop.getCurrentOrder().getTotalItems(); i++) {
            Beverage b = bevShop.getCurrentOrder().getBeverage(i);
            if (b instanceof Smoothie) {
                totalFruits += ((Smoothie) b).getNumOfFruits();
            }
        }

        if (totalFruits >= bevShop.getMaxNumOfFruits()) {
            System.out.println("The total number of fruits is " + totalFruits);
            System.out.println("You reached a Maximum number of fruits");
        }

        double secondOrderTotal = bevShop.getOrderAtIndex(1).calcOrderTotal();
        System.out.println("\nTotal price on the second Order: " + secondOrderTotal);
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());

        scanner.close();
    }
}
