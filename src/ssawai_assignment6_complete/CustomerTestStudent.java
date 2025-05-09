package ssawai_assignment6_complete;

/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: The CustomerTestStudent class is a JUnit test suite designed to verify the correctness of the Customer class in the BevShop project.
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

public class CustomerTestStudent {
    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Jane", 28);
        Customer copy = new Customer(original);
        assertEquals("Jane", copy.getName());
        assertEquals(28, copy.getAge());
    }

    @Test
    public void testSetters() {
        Customer customer = new Customer("Mike", 22);
        customer.setName("Tom");
        customer.setAge(30);
        assertEquals("Tom", customer.getName());
        assertEquals(30, customer.getAge());
    }
}