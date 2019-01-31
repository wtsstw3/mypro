package simple.singleton;

/**
 * Created by Black on 09.09.2018.
 */
public class SingletonDoubleChecked {
    public static void main (String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton + " " + singleton1);
    }

    /**
     * Created by Black on 09.09.2018.
     */
    static class Singleton {
        private static volatile Singleton instance;
        private Singleton() {

        }
        public static synchronized Singleton getInstance() {
            Singleton localSingle = instance;
            if(localSingle== null) {
                synchronized (Singleton.class) {
                    localSingle = instance;
                    if(localSingle == null) {
                        localSingle = new Singleton();
                        instance = localSingle;
                    }
                }
            }
            return instance;
        }
    
    }
}

