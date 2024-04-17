
// Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program
// should print randomly the name of thread and value of sleep time. The name of the
// thread should be hard coded through constructor. The sleep time of a thread will be a
// random integer in the range 0 to 4999. 
import java.util.Random;

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " started.");

        Random rand = new Random();

        try {
            // Simulate the lifecycle of the thread
            for (int i = 0; i < 5; i++) {
                int sleepTime = rand.nextInt(5000); // Random sleep time between 0 to 4999 milliseconds
                System.out.println("Thread " + name + " sleeping for " + sleepTime + " milliseconds.");
                Thread.sleep(sleepTime);
                System.out.println("Thread " + name + " awake.");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + " interrupted.");
        }

        System.out.println("Thread " + name + " finished.");
    }
}

public class q2 {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");

        thread1.start();
        thread2.start();
    }
}