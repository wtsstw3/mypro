package simple;

public class TestThread {

    public static void main(String[] args) {
        FileTest fileTest = new FileTest();
        ThreadTest threadTest = new ThreadTest();
        try {
            threadTest.runThreadTest();
        } catch (final Exception e) {
            System.out.println("ААаААААаааАААаа");
        }
    }
}
