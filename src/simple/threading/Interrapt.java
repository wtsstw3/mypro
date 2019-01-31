package simple.threading;

/**
 * Created by Black on 09.09.2018.
 */
public class Interrapt {
    public static void main(String[] args) throws InterruptedException {
        InterraptedThread interraptedThread = new InterraptedThread();
            Thread thread = new Thread(interraptedThread);
            thread.start();
            thread.interrupt();
            thread.join();
    }
}


class InterraptedThread implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(2);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(1);
            e.printStackTrace();
        }
    }

}
