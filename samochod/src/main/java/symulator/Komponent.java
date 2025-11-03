package symulator;

public class Komponent {

    public String producent;
    public String model;

    public Komponent(String producent, String model) {
        this.producent = producent;
        this.model = model;

    }

    public String getProducent() {
        return producent;
    }
    public String getModel() {
        return model;
    }
}
