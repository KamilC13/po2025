package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja pozycja;
    public String nrRjst;
    public String modelAuta;
    public int wagaAuta;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia,  Pozycja pozycja, String nrRjst, String modelAuta, int wagaAuta) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.pozycja = pozycja;
        this.nrRjst = nrRjst;
        this.modelAuta = modelAuta;
        this.wagaAuta = wagaAuta;
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
    public String getModel(){
        return modelAuta;
    };
    public String getNrRjst(){
        return nrRjst;
    };
    public int getWagaAuta(){
        return wagaAuta;
    };

}