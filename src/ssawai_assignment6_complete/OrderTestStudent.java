package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The OrderTestStudent class is a JUnit test suite designed to verify the correctness of the Order class in the BevShop project.
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

public class OrderTestStudent {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order(12, Day.THURSDAY, new Customer("Rick", 35));
    }

    @Test
    public void testAddNewBeverageAndTotal() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Smoothie", Size.SMALL, 2, false);
        assertEquals(2, order.getTotalItems());
        assertTrue(order.calcOrderTotal() > 0);
    }

    @Test
    public void testCompareTo() {
        Order another = new Order(10, Day.MONDAY, new Customer("Rick", 35));
        assertNotEquals(0, order.compareTo(another));
    }
}
