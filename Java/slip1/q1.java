// Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2
// seconds.

class q1 extends Thread {
    char c;

    public void run() {
        for (c = 'A'; c <= 'Z'; c++) {
            System.out.println("" + c);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
public static void main(String args[])
{
q1 t = new q1();
t.start();
}
}