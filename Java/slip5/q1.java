// Write a Java Program to create the hash table that will maintain the mobile number and
// student name. Display the details of student using Enumeration interface

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        // Create a hash table to store student details (name as key, mobile number as value)
        Hashtable<String, String> ht = new Hashtable<>();

        // Add some sample data to the hash table
        ht.put("John Doe", "1234567890");
        ht.put("Jane Smith", "9876543210");
        ht.put("Alice Johnson", "5555555555");

        // Display the details of students using Enumeration
        System.out.println("Details of Students:");
        Enumeration<String> names = ht.keys();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String mobileNumber = ht.get(name);
            System.out.println("Name: " + name + ", Mobile Number: " + mobileNumber);
        }
    }
}
