package simple.threading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Black on 08.09.2018.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger countSaveThreads = new AtomicInteger(0);
        AtomicInteger countHelpThreads = new AtomicInteger(0);
        Save save = new Save(countSaveThreads);
        Help help = new Help(countHelpThreads);
        for (int i=0; i<10; i++) {
            Thread thread = new Thread(save);
            Thread thread1 = new Thread(help);
            thread.start();
            thread.join();
            thread1.start();
            thread1.join();
        }
    }
}

interface Print {
    void print();
}

class Save implements Runnable, Print {

    private AtomicInteger countSaveThreads;

    Save(AtomicInteger countSaveThreads) {
        this.countSaveThreads = countSaveThreads;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countSaveThreads.incrementAndGet();
        print();
    }

    @Override
    public void print() {
        System.out.println("Спасите " + countSaveThreads + " раз");
    }
}

class Help implements Runnable, Print {

    AtomicInteger countHelpThreads;

    Help(AtomicInteger countHelpThreads) {
        this.countHelpThreads = countHelpThreads;
    }

    @Override
    public void run() {
        countHelpThreads.incrementAndGet();
        print();
    }

    @Override
    public void print() {
        System.out.println("Памагите " + countHelpThreads + " раз");
    }
}
