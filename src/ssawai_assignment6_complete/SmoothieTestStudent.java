package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The SmoothieTestStudent class is a JUnit test suite designed to verify the correctness of the Smoothie class in the BevShop project.
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

public class SmoothieTestStudent {
    @Test
    public void testCalcPriceWithProtein() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 2, true);
        assertEquals(5.0, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Smoothie s1 = new Smoothie("Tropical", Size.LARGE, 3, false);
        Smoothie s2 = new Smoothie("Tropical", Size.LARGE, 3, false);
        assertTrue(s1.equals(s2));
    }
}