package animals;

public class Dog extends Animal{
    public Dog(String name){
        super(name, 4);
    }
    public String getDescription(){
        return this.name;
    };
    public int getDescription2(){
        return this.legs;
    };
}
