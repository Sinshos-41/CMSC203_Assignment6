package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The CoffeeTestStudent class is a JUnit test suite designed to verify the correctness of the Coffee class in the BevShop project.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoffeeTestStudent {
    @Test
    public void testCalcPriceWithExtras() {
        Coffee coffee = new Coffee("Espresso", Size.MEDIUM, true, true);
        assertEquals(3.5, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Coffee c1 = new Coffee("Mocha", Size.LARGE, false, true);
        Coffee c2 = new Coffee("Mocha", Size.LARGE, false, true);
        assertTrue(c1.equals(c2));
    }
}
