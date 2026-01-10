package symulator;

public class Sprzeglo extends Komponent{
    public boolean StanSprzegla;

    public Sprzeglo(String producent, String model, int cena, int waga, boolean StanSprzegla){
        super(producent, model, cena, waga);
        this.StanSprzegla=StanSprzegla;
    }
    public Sprzeglo() {
        this.StanSprzegla = false;
        this.cena = 0;
        this.waga = 0;
        this.producent = "";
        this.model = "";
    }

    public void wcisnij(){
        StanSprzegla = true; //sprzeglo jest wciskane
    }

    public void zwolnij(){
        StanSprzegla = false; //sprzeglo nie jest wciskane
    }

    public boolean isStanSprzegla() {
        return StanSprzegla;
    }

}
