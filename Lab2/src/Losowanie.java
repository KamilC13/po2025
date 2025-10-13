import java.util.*;

public class Losowanie {
    Random rand = new Random();
    ArrayList lista = new ArrayList<>();
    ArrayList listatypy = new ArrayList();
    int zgodne = 0;

    public void typy(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i <= 5; i++){
            int wybor = Integer.parseInt(sc.next());
            listatypy.add(wybor);
        }
        System.out.println("Wybrane typy: " + listatypy);
    }
    public void adding() {
        for (int i = 0; i <= 5; i++) {
            lista.add(rand.nextInt(49) + 1);
        }
    }
    public int spr() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (lista.get(i).equals(listatypy.get(j))) {
                    zgodne++;
                }
            }
        }
        return zgodne;
    }
    public void czyszczenie(){
        lista.clear();
        zgodne = 0;
    }



    public static void main(String[] args) {
        Losowanie proba = new Losowanie();
        int liczba = 0;
        proba.typy();

        while(proba.zgodne != 6){
            proba.adding();
            proba.spr();
            liczba++;
            proba.czyszczenie();
        }
        System.out.println("Liczba przejsc: " + liczba);
        System.out.println("Trafionych jest: " + proba.zgodne);
        }
    }



