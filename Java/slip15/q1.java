// Write a java program to display name and priority of a Thread. 
public class q1 {
    public static void main(String arg[]) {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread:" + t);// Change Name
        t.setName("My Thread ");
        System.out.println("After the name is Changed:" + t);
        try {
            for (int i = 2; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}