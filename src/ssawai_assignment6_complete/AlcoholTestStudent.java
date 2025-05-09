package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The AlcoholTestStudent class is a JUnit test suite designed to verify the correctness of the Alcohol class in the BevShop project. It includes tests for:
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

public class AlcoholTestStudent {
    @Test
    public void testCalcPrice() {
        Alcohol drink = new Alcohol("Whiskey", Size.LARGE, true);
        assertEquals(3.6, drink.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Alcohol drink = new Alcohol("Beer", Size.SMALL, false);
        assertTrue(drink.toString().contains("Beer"));
    }

    @Test
    public void testEquals() {
        Alcohol a1 = new Alcohol("Wine", Size.MEDIUM, true);
        Alcohol a2 = new Alcohol("Wine", Size.MEDIUM, true);
        assertTrue(a1.equals(a2));
    }
}
