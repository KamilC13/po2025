package symulator;

public class Komponent {

    public String producent;
    public String model;
    public int cena;
    public int waga;

    public Komponent(String producent, String model, int cena, int waga) {
        this.producent = producent;
        this.model = model;
        this.cena = cena;
        this.waga = waga;
    }
    public Komponent() {
        this("", "", 0, 0);
    }


    public String getProducent() {
        return producent;
    }
    public String getModel(){
        return model;
    }
    public int getCena(){
        return cena;
    }
    public int getWaga(){
        return waga;
    }
    public void setModel(){
        this.model = model;
    }
    public void setCena(){
         this.cena=cena;
    }
    public void setWaga(){
        this.waga=waga;
    }

}
