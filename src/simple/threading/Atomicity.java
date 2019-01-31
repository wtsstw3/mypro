package simple.threading;

/**
 * Created by Black on 09.09.2018.
 */
public class Atomicity extends Thread {
    volatile static int i;
    boolean b;

    public void run() {
        while(true) {
            synchronized (Atomicity.class) {
                if (b = !b)
                    i++;
                else i--;
            }
        }
    }
    public static void main (String...args){
        new Atomicity().start();
        new Atomicity().start();
        while (true) System.out.println(i);
    }
}
