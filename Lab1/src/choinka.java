import java.util.Scanner;

public class choinka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int liczba = Integer.parseInt(sc.next());
        String Star = "*";
        for (int i=0; i < liczba; i++){
            System.out.println(Star);
            Star += "*";
        }

    }
}
