package Beecrowd;
import java.util.*;

public class Main1006 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();

        double media = ((a*2) + (b*3) + (c*5)) / 10;

        System.out.printf("MEDIA = %.1f\n", media);
    }
}
