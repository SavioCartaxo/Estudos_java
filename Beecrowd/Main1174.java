package Beecrowd;

import java.util.*;

public class Main1174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] a = new double[100];

        for (int i = 0; i < 100; i++) {
            a[i] = sc.nextFloat();
            if (a[i] <= 10) {
                System.out.printf("A[%d] = %.1f%n", i, a[i]);
            }
        }

        sc.close();

    }
}
