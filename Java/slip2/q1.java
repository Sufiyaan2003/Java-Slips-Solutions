// Write a java program to read ‘N’ names of your friends, store it into HashSet and
// // display them in ascending order

import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating a HashSet to store the names
        Collection<String> c = new HashSet<>();

        System.out.print("Enter the number of friends: ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        // Reading 'N' names and storing them in the HashSet
        for (int i = 0; i < N; i++) {
            System.out.print("Enter friend name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            c.add(name);
        }

        // Displaying names in ascending order
        List<String> sortedNames = new ArrayList<>(c);
        Collections.sort(sortedNames);

        System.out.println("\nFriends in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
