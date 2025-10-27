package animals;

public class Parrot extends Animal {

    public Parrot(String name){
        super(name, 2);
    }

    public String getDescription(){
        System.out.println(this.name);
        return this.name;
    };
    public int getDescription2(){
        System.out.println(this.legs);
        return this.legs;
    };


}
