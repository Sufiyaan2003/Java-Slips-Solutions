// Write a Java program to accept ‘n’ integers from the user and store them in a collection.
// Display them in the sorted order. The collection should not accept duplicate elements.
// (Use a suitable collection). Search for a particular element using predefined search
// method in the Collection framework

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept 'n' integers from the user
        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();

        // Create a TreeSet to store integers (automatically sorts and removes duplicates)
        Set<Integer> numbers = new TreeSet<>();

        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num); // Add the integer to the set
        }

        // Display integers in sorted order
        System.out.println("Integers in sorted order:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // Search for a particular element
        System.out.print("Enter the element to search for: ");
        int searchElement = scanner.nextInt();

        if (numbers.contains(searchElement)) {
            System.out.println("Element " + searchElement + " found in the collection.");
        } else {
            System.out.println("Element " + searchElement + " not found in the collection.");
        }

        scanner.close();
    }
}
