package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja pozycja;;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia,  Pozycja pozycja) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.pozycja = pozycja;
    }
    public void wlacz(){
        silnik.uruchom();
    }
    public void wylacz(){
        silnik.zatrzymaj();
        skrzynia.aktualnyBieg = 0;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Silnik getSilnik() {
        return silnik;
    }


    public Pozycja getPozycja() {
        return pozycja;
    }
}