package simple;

import java.util.concurrent.ForkJoinPool;

public class java8 {
   static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());    // 3
    }
}
