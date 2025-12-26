package symulator;

public class Pozycja {
    public double x;
    public double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Pozycja(){
        this.x = 0;
        this.y = 0;
    }


    public void AktuazlizujPozycje(double deltax, double deltay) {
        this.x=this.x+deltax;
        this.y=this.y+deltax;
    }
    String getPozycja(double x, double y) {
        return x + " " + y;
    }

}