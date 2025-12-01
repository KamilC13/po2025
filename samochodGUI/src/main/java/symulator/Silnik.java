package symulator;

public class Silnik extends Komponent {

    public int maxObroty;
    public int obroty;

    public Silnik(String producent, String model, int maxObroty, int obroty) {
        super(producent, model);
        this.maxObroty=maxObroty;
        this.obroty=obroty;
    }

    public void uruchom(){}
    public void zatrzymaj(){}
    public int getObroty() {
        return obroty;
    }

}
