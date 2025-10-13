import java.util.*;

public class Losowanie {
    Random rand = new Random();
    ArrayList lista = new ArrayList();
    ArrayList listatypy = new ArrayList();
    int zgodne = 0;

    public ArrayList typy(){
        Scanner sc = new Scanner(System.in);
        while(listatypy.size()<6){
            int n = sc.nextInt();
            if(!listatypy.contains(n) && n<=49){
                listatypy.add(n);
            }
            else {
                System.out.println("Wypisujesz glupoty!");
            }
        }
        return listatypy;
    }
    public ArrayList adding() {
        while(lista.size() < 6){
            int num = rand.nextInt(49)+1;
            if(!lista.contains(num)){
                lista.add(num);
            }
        }
        return lista;
    }
    public int spr() {
        zgodne = 0;
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
    }


    public static void main(String[] args) {
        Losowanie proba = new Losowanie();
        int liczba = 0;
        int trafione = 0;

        proba.typy();
        while(trafione != 6) {
            proba.adding();
            trafione = proba.spr();
            liczba++;
            if(trafione != 6) {
                proba.czyszczenie();
            }
        }
        System.out.println("typy " + proba.listatypy);
        System.out.println("wylosowane " + proba.lista);
        System.out.println("zgodna ilosc " + proba.zgodne);
        System.out.println("ilosc losowan " + liczba);

    }
}



