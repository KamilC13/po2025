package symulator;

public class SkrzyniaBiegow extends Komponent{
    public int aktualnyBieg;
    public int iloscBiegow;
    Sprzeglo sprzeglo;

    public SkrzyniaBiegow (String producent, Sprzeglo sprzeglo, int cena, int waga, String model, int akluanyBieg, int iloscBiegow) {
        super(producent, model, cena, waga);
        this.sprzeglo = sprzeglo;
        this.aktualnyBieg=akluanyBieg;
        this.iloscBiegow=iloscBiegow;;
    }
    public SkrzyniaBiegow(){
        this.sprzeglo = new Sprzeglo();
        this.aktualnyBieg=0;
        this.iloscBiegow=6;
        this.cena = 0;
        this.waga = 0;
        this.producent = "";
        this.model = "";
    }

    public void ZwiekszBieg(){
        if(aktualnyBieg < iloscBiegow)
        {
            aktualnyBieg++;
            System.out.println("Bieg zwiekszony na " + aktualnyBieg);
        }
        if(aktualnyBieg == iloscBiegow)
        {
            System.out.println("Jestes juz na maksymalnym biegu");
        }
    }
    public void ZmiejszBieg(){
        if(aktualnyBieg > 1)
        {
            aktualnyBieg--;
            System.out.println("Bieg zmniejszony na " + aktualnyBieg);
        }
        if(aktualnyBieg == 1)
        {
            System.out.println("Jestes juz na 1");
        }
    }
    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }
}
