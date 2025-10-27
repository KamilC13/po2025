package zadania;
import animals.*;

import java.util.Arrays;
import java.util.Random;

public class Zoo {
    public static Animal[] animals = new Animal[100];

    public void fun() {
        Random rand = new Random();
        String[] imiona = {"tomek", "franek", "marian", "kacper"};
        for (int i = 0; i < animals.length; i++) {
            int number = rand.nextInt(3) + 1;
            String name = imiona[rand.nextInt(imiona.length)];
            switch (number) {
                case 1 -> animals[i] = new Parrot(name);
                case 2 -> animals[i] = new Snake(name);
                case 3 -> animals[i] = new Dog(name);
            }
        }
    }
    public int liczenie(){
        int suma = 0;
        for(int i = 0; i < 100; i++){
            suma += animals[i].getDescription2();
        }
        System.out.println(suma);
        return suma;
    }
    public void toString1(){
        for(int i = 0; i < animals.length; i++){
            System.out.println(animals[i].getClass().getSimpleName() + " " + animals[i].getDescription());
        }
    }

    }

