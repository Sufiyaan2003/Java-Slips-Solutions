// Write a java program to display name and priority of a Thread. 

public class q1 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}