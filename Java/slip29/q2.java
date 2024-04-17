// Write a Java program to create LinkedList of integer objects and perform the following:
// i. Add element at first position
// ii. Delete last element
// iii. Display the size of link list

import java.util.LinkedList;

public class q2 {
    public static void main(String[] args) {
        // Create a LinkedList of integers
        LinkedList<Integer> list = new LinkedList<>();
        // Add element at the first position
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("LinkedList after adding elements at first position: " + list);
        // Delete the last element
        list.removeLast();
        System.out.println("LinkedList after deleting last element: " + list);
        // Display the size of LinkedList
        System.out.println("Size of LinkedList: " + list.size());
    }
}