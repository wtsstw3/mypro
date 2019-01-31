package simple.inheritance;

/**
 * Created by Black on 08.09.2018.
 */
public class Main {
    public static void main (String[] args){
        Cat cat = new Cat(1,2);
        System.out.println("Я обычный кот");
        cat.print();
        System.out.println(cat.x + " " + cat.z + " " + Cat.z + " " + cat.sum);
        Pet cat1 = new Cat(1,2);
        System.out.println("Я экземпляр пета кот");
        cat1.print();
        System.out.println(cat1.x + " " + cat1.z);
        System.out.println(((Cat)cat1).x + " " + ((Cat)cat1).z);
        Pet pet = new Pet();
        System.out.println(pet.x + " " + pet.z);
    }
}

class Pet {
    int x = 0,y=5;
    static int z = 3;
    static {
        System.out.println(z);
        z = 2;
    }
    static {
        System.out.println("Большую роль сыграл в твоей судьбе");
        System.out.println(z);
    }
    Pet() {
        //super()
        //this.x = 0;
        //this.y = 5;
        //Kod konstructora
    }


    public void print() {
        System.out.println("I'm pet");
    }
}

class Cat extends Pet {
    static {
        System.out.println("привет я кот");
    }
    int x = 2;
    int sum = getSum();
    int y = 2;
    static int z = 1;
    Cat(int x, int y) {
        //super()
        //this.x = 1;
        //this.y = 2;
        //Na4alo kod konstruktora
        System.out.println("Конструктор кота " + x);
        this.x = x;
        this.y = y;
    }

    public int getSum()
    {
        return 2*x + y;
    }


    public void print() {
        System.out.println("I'm cat");
    }
}

