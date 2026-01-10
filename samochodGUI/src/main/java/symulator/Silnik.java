package symulator;

public class Silnik extends Komponent {

    public int maxObroty;
    public int obroty;
    public double predkosc;
    public int maxpredkosc;
    private boolean uruchomiony = false;


    public Silnik(String producent, String model, int cena, int waga, int maxObroty, int obroty, double predkosc, int maxpredkosc) {
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
        if (!uruchomiony) {
            return obroty;
        }
        if (obroty - oIle >= 0) obroty -= oIle;
        else obroty = 0;
        return obroty;
    }

    public int ZwiekszObroty(int oIle) {
        if (!uruchomiony) {
            return obroty;
        }
        if (obroty + oIle <= maxObroty) obroty += oIle;
        else obroty = maxObroty;
        return obroty;
    }
    public boolean isUruchomiony() {
        return uruchomiony;
    }
    public double getPredkosc(){
        return predkosc;
    }
    public double getMaxPredkosc(){
        return maxpredkosc;
    }
    public boolean uruchom(){
        uruchomiony = true;
        obroty = 1000;
        return true;
    }
    public boolean zatrzymaj(){
        uruchomiony = false;
        obroty=0;
        predkosc=0;
        return false;
    }
    public int getObroty(){
        return obroty;
    }
    public String toString(){
        return model;
    }

    public double setPredkosc(double predkosc) {
        return this.predkosc=predkosc;
    }
}

