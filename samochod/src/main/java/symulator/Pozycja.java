package symulator;

public class Pozycja {
    public double x;
    public double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public void AktuazlizujPozycje(double deltax, double deltay) {
        this.x=this.x+deltax;
        this.y=this.y+deltax;
    }
    public double getPozycjaX() {
        return this.x;
    }
    public double getPozycjaY() {
        return this.y;
    }
}