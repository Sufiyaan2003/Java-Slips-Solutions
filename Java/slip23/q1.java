// Write a java program to accept a String from a user and display each vowel from a
// String after every 3 seconds. 

import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine().toLowerCase(); // convert input to lowercase
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (isVowel(c)) {
                System.out.print(c + " ");
                try {
                    Thread.sleep(3000); // pause for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}