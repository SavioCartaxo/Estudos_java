package Beecrowd;
import java.util.*;

public class Main1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        for(int i = 0; i < 10; i++) {
            System.out.printf("N[%d] = %d%n", i, n);
            n*=2;
        }
    }
}
