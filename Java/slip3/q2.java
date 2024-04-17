// Write a Java program to create LinkedList of String objects and perform the following:
// i. Add element at the end of the list
// ii. Delete first element of the list
// iii. Display the contents of list in reverse order.

import java.util.*;

public class q2 {
    public static void main(String[] args) {
        // Creating a LinkedList using the Collection interface
        Collection<String> c = new LinkedList<>();

        // i. Add elements at the end of the list
        c.add("Apple");
        c.add("Banana");
        c.add("Orange");

        System.out.println("LinkedList after adding elements: " + c);

        // ii. Delete the first element of the list
        if (!c.isEmpty()) {
            Iterator<String> iterator = c.iterator();
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }

        System.out.println("LinkedList after deleting first element: " + c);

        // iii. Display the contents of the list in reverse order
        if (!c.isEmpty()) {
            List<String> reverseList = new ArrayList<>((LinkedList<String>) c);
            Collections.reverse(reverseList);
            System.out.println("LinkedList contents in reverse order: " + reverseList);
        } else {
            System.out.println("The LinkedList is empty.");
        }
    }
}
