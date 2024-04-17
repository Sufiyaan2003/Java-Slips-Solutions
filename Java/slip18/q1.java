// Write a java program using Multithreading to display all the vovels from a given string. Each vovel should be displayed after every 3 seconds

public class q1 {
    public static void main(String[] args) {
        String inputString = "Hello, how are you?";
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        // Create a thread for each vowel
        for (int i = 0; i < vowels.length; i++) {
            new VowelThread(inputString, vowels[i]).start();
        }
    }
}

class VowelThread extends Thread {
    private String inputString;
    private char vowel;

    public VowelThread(String inputString, char vowel) {
        this.inputString = inputString;
        this.vowel = vowel;
    }

    @Override
    public void run() {
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == vowel) {
                System.out.println(vowel);
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
