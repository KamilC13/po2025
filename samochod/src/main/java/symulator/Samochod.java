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
    public Silnik getSilnik() {
        return silnik;
    }
    public Pozycja getPozycja() {
        return pozycja;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }
    public void wlacz(){
        silnik.uruchom();
        System.out.println("Silnik wlaczony");
    }
    public void wylacz(){
        silnik.zatrzymaj();
        System.out.println("Silnik wylaczony");
    }
}