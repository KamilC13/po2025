package animals;

public abstract class Animal {
     protected int legs;
     protected String name;

     public Animal(String name, int legs){
         this.legs = legs;
         this.name = name;
     }
     public abstract String getDescription();
     public abstract int getDescription2();

}

