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

    public int ZmniejszObroty(int oIle) {
        if (obroty - oIle >= 0) {
            obroty -= oIle;
        } else {
            System.out.println("Bledna wartosc - bez zmiany ");
        }
        return obroty;
    }


    public int ZwiekszObroty(int oIle) {
        if (obroty + oIle <= maxObroty) {
            obroty += oIle;
        } else {
            obroty = maxObroty;
        }
        return obroty;
    }
    /*public int obliczPredkosc() {
        if (this.obroty <= 0) {
            return 0;
        }
        return this.obroty / 40;
    }*/
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

