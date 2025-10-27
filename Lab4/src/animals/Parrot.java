package animals;

public class Parrot extends Animal {

    public Parrot(String name){
        super(name, 2);
    }

    public String getDescription(){
        return this.name;
    };
    public int getDescription2(){
        return this.legs;
    };


}
