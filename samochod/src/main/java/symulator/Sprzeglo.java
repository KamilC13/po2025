package symulator;

public class Sprzeglo extends Komponent{
    public boolean StanSprzegla;

    public Sprzeglo(String producent, String model, boolean StanSprzegla){
        super(producent, model);
        this.StanSprzegla=StanSprzegla;
    }

    public void wcisnij(){
        StanSprzegla = true; //sprzeglo jest wciskane
    }

    public void zwolnij(){
        StanSprzegla = false; //sprzeglo nie jest wciskane
    }
}
