package zadania;
import animals.*;

import java.util.Random;

public class Zoo {
    static void main() {
        Animal[] animals = new Animal[100];
        Random rand = new Random();
        String[] imiona = {"tomek", "franek"};
        for (int i = 0; i < animals.length; i++) {
            int number = rand.nextInt(3) + 1;
            String name = imiona[rand.nextInt(imiona.length)];
            switch (number){
                case 1 -> animals[i] = new Parrot(name);
                case 2 -> animals[i] = new Snake(name);
                case 3 -> animals[i] = new Dog(name);
            }
        }

        }
    }

