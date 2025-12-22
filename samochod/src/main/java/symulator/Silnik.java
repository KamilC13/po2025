package symulator;

public class Silnik extends Komponent {

    public int maxObroty;
    public int obroty;
    public int predkosc;
    public int maxpredkosc;

    public Silnik(String producent, String model, int maxObroty, int obroty, int predkosc, int maxpredkosc) {
        super(producent, model);
        this.maxObroty=maxObroty;
        this.obroty=obroty;
        this.predkosc=predkosc;
    }
    public int ZmniejszV(int oIleZmnijeszamyV){
        if(predkosc-oIleZmnijeszamyV>0){
            predkosc-=oIleZmnijeszamyV;
        }
        else {
            System.out.println("Bledna wartosc - bez zmiany predkosci");
        }
        return predkosc;
    }
    public int ZwiekszV(int oIleZwiekszamyV){
        if(predkosc+oIleZwiekszamyV<maxpredkosc){
            predkosc+=oIleZwiekszamyV;
        }
        else {
            System.out.println("Bledna wartosc - bez zmiany predkosci");
        }
        return predkosc;
    }
    public void uruchom(){
        obroty=1000;
    }
    public void zatrzymaj(){
        obroty=0;
    }


}
