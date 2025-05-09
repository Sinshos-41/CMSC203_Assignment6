package ssawai_assignment6_complete;
/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: Stores customer name and age. Includes a copy constructor for deep copying, and overrides toString() to print customer details.
 * Due: 05/08/2025
 * Platform/compiler: Eclipse IDE Java
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sinsho Sawai_
*/
//Represents a Customer.
public class Customer {
    private String name;
    private int age;

 //Constructs a Customer with name and age.
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

 //Copy constructor to create a new Customer based on another.
    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }

 //Gets the customer's name.
    public String getName() {
        return name;
    }

 //Sets the customer's name.
    public void setName(String name) {
        this.name = name;
    }

 //Gets the customer's age.
    public int getAge() {
        return age;
    }

 //Sets the customer's age.
    public void setAge(int age) {
        this.age = age;
    }

 //Returns a string representation of the customer.
    @Override
    public String toString() {
        return name + ", " + age;
    }
}
