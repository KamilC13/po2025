package symulator;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread {
    Silnik silnik;
    SkrzyniaBiegow skrzynia;
    Pozycja pozycja;
    public String nrRjst;
    public String modelAuta;
    public double wagaAuta;
    int maxspeed;

    private Pozycja cel;
    private List<Listener> listeners = new ArrayList<>();


    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Pozycja pozycja, String nrRjst, String modelAuta, double wagaAuta, int maxspeed) {
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.pozycja = pozycja;
        this.nrRjst = nrRjst;
        this.modelAuta = modelAuta;
        this.wagaAuta = wagaAuta;
        this.maxspeed=maxspeed;

        start();
    }
    public Samochod(){
        this.silnik=new Silnik();
        this.skrzynia=new SkrzyniaBiegow();
        this.pozycja=new Pozycja();
        this.nrRjst="0";
        this.modelAuta="";
        this.wagaAuta=0;

        start();
    }
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }
    public void jedzDo(Pozycja cel) {
        this.cel = cel;
        System.out.println("Otrzymano nowy cel: " + cel.getX() + ", " + cel.getY());
    }
    @Override
    public void run() {

        double deltat = 0.01;

        while (true) {
            try {
                if (cel != null) {
                    double dx_diff = cel.getX() - pozycja.getX();
                    double dy_diff = cel.getY() - pozycja.getY();

                    double odleglosc = Math.sqrt(Math.pow(dx_diff, 2) + Math.pow(dy_diff, 2));

                    if (odleglosc > 5) {
                        double predkosc = silnik.getPredkosc();

                        double dx = predkosc * deltat * (dx_diff / odleglosc);
                        double dy = predkosc * deltat * (dy_diff / odleglosc);

                        // aktualizacja pozycji
                        pozycja.AktuazlizujPozycje(dx, dy);

                        notifyListeners();

                    } else {
                        cel = null; // Zatrzymanie po dotarciu
                    }
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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