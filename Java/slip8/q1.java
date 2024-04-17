// Write a java program to define a thread for printing text on output screen for ‘n’
// number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the
// thread constructor.
//  Example:
// i. First thread prints “COVID19” 10 times.
// ii. Second thread prints “LOCKDOWN2020” 20 times
// iii. Third thread prints “VACCINATED2021” 30 times

import slip14.q1;

public class q1 extends Thread {
    String str;
    int n;

    q1(String str, int n) {
        this.str = str;
        this.n = n;
    }

    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                System.out.println(getName()+ " : " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        q1 t1 = new q1("COVID19", 10);
        q1 t2 = new q1("LOCKDOWN2020", 20);
        q1 t3 = new q1("VACCINATED", 30);
        t1.start();
        t2.start();
        t3.start();
    }
}
