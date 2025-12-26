package symulator;

public class Samochod {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja pozycja;
    public String nrRjst;
    public String modelAuta;
    public double wagaAuta;
    int maxspeed;

    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Pozycja pozycja, String nrRjst, String modelAuta, double wagaAuta, int maxspeed) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.pozycja = pozycja;
        this.nrRjst = nrRjst;
        this.modelAuta = modelAuta;
        this.wagaAuta = wagaAuta;
        this.maxspeed=maxspeed;
    }
    public Samochod(){
        this.silnik=new Silnik();
        this.skrzynia=new SkrzyniaBiegow();
        this.pozycja=new Pozycja();
        this.nrRjst="0";
        this.modelAuta="";
        this.wagaAuta=0;
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
    public double getWagaAuta(){
        return wagaAuta;
    };
    public void setWagaAuta(double wagaAuta) {
        this.wagaAuta = wagaAuta;
    }
    public void setNrRjst(String nrRjst) {
        this.nrRjst = nrRjst;
    }
    public void setModelAuta(String modelAuta) {
        this.modelAuta = modelAuta;
    }
    @Override
    public String toString() {
        return getModel();
    }



}