package animals;

public class Snake extends Animal{
    public Snake(String name){
        super(name, 0);
    }
    public String getDescription(){
        return this.name;
    };
    public int getDescription2(){
        return this.legs;
    };
}
