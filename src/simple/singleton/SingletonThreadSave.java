package simple.singleton;

/**
 * Created by Black on 09.09.2018.
 */
public class SingletonThreadSave {
    public static void main (String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton + " " + singleton1);
    }

    /**
     * Created by Black on 09.09.2018.
     */
    static class Singleton {
        private static Singleton instance;
        private Singleton() {

        }
        public static synchronized Singleton getInstance() {
            if (instance==null) instance = new Singleton();
            return instance;
        }
    
    }
}

