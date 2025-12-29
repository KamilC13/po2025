package symulator;

public class Silnik extends Komponent {

    public int maxObroty;
    public int obroty;
    public int predkosc;
    public int maxpredkosc;

    public Silnik(String producent, String model, int cena, int waga, int maxObroty, int obroty, int predkosc, int maxpredkosc) {
        super(producent, model, cena, waga);
        this.maxObroty=maxObroty;
        this.obroty=obroty;
        this.predkosc=predkosc;
        this.maxpredkosc=maxpredkosc;
    }
    public Silnik(){
        this.maxObroty=6700;
        this.obroty=0;
        this.cena = 0;
        this.waga = 0;
        this.producent = "";
        this.model = "";
        this.predkosc=0;
        this.maxpredkosc=0;
    }

    public int ZmniejszV(int oIle) {
        if (predkosc - oIle >= 0) {
            predkosc -= oIle;
        } else {
            System.out.println("Bledna wartosc - bez zmiany ");
        }
        return predkosc;
    }


    public int ZwiekszV(int oIle) {
        if (predkosc + oIle <= maxpredkosc) {
            predkosc += oIle;
        } else {
            predkosc = maxpredkosc;
        }
        return predkosc;
    }

    public int getPredkosc(){
        return predkosc;
    }
    public void uruchom(){
        obroty=1000;
    }
    public void zatrzymaj(){
        obroty=0;
        predkosc=0;
    }
    public int getObroty(){
        return obroty;
    }
    public String toString(){
        return model;
    }

}

