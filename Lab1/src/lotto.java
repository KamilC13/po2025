import java.util.Random;

public class lotto {
    public static void main(String[] args) {
        Random r = new Random ();
        int[] tablica = new int[6];
        for (int i=0;i<6;i++){
            int liczba = r.nextInt(49);
            tablica[i] = liczba;
            System.out.println(tablica[i]);
        }

    }
}
