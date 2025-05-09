package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The BevShopTestStudent class is a JUnit test suite designed to verify the correctness of the BevShop class in the BevShop project.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTestStudent {
    private BevShop shop;

    @BeforeEach
    public void setUp() {
        shop = new BevShop();
    }

    @Test
    public void testStartNewOrderAndTotal() {
        shop.startNewOrder(10, Day.MONDAY, "Anna", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(2.5, shop.getCurrentOrder().calcOrderTotal(), 0.01);
    }

    @Test
    public void testAlcoholLimit() {
        shop.startNewOrder(9, Day.SATURDAY, "Mark", 30);
        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processAlcoholOrder("Wine", Size.MEDIUM);
        shop.processAlcoholOrder("Whiskey", Size.LARGE);
        shop.processAlcoholOrder("Vodka", Size.SMALL); // should not be added
        assertEquals(3, shop.getCurrentOrder().getTotalItems());
    }
}