package symulator;

public class SkrzyniaBiegow extends Komponent{
    public int akluanyBieg;
    public int iloscBiegow;
    Sprzeglo sprzeglo;

    public SkrzyniaBiegow (String producent, Sprzeglo sprzeglo, String model, int akluanyBieg, int iloscBiegow) {
        super(producent, model);
        this.sprzeglo = sprzeglo;
        this.akluanyBieg=akluanyBieg;
        this.iloscBiegow=iloscBiegow;;

    }

    public void ZwiekszBieg(){
        if(akluanyBieg < iloscBiegow)
        {
            akluanyBieg++;
            System.out.println("Bieg zwiekszony na " + akluanyBieg);
        }
        if(akluanyBieg == iloscBiegow)
        {
            System.out.println("Jestes juz na maksymalnym biegu");
        }
    }
    public void ZmiejszBieg(){
        if(akluanyBieg > 1)
        {
            akluanyBieg--;
            System.out.println("Bieg zmniejszony na " + akluanyBieg);
        }
        if(akluanyBieg == 1)
        {
            System.out.println("Jestes juz na 1");
        }
    }
}
