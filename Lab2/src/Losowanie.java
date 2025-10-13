import java.util.*;

public class Losowanie {
    Random rand = new Random();
    ArrayList<Integer> lista = new ArrayList<>();

    public void adding() {
        for (int i = 0; i <= 5; i++) {
            lista.add(rand.nextInt(49) + 1);
        }
        System.out.println("Wylosowane liczby: " + lista);
    }
    public static void main(String[] args){
        Losowanie proba = new Losowanie();
        proba.adding();
    }
}


