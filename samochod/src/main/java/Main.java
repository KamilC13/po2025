import symulator.*;

public class Main {
    public static void main(String[] args) {
        Silnik silnik = new Silnik("honda", "V6",8000, 3000);
        Sprzeglo sprzeglo = new Sprzeglo("Valeo", "B3", true);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("VW", sprzeglo, "H4", 5, 6);;
        Pozycja pozycja = new Pozycja(4,5);

        Samochod s = new Samochod(silnik, skrzynia, pozycja);
        s.wlacz();
    }
}

