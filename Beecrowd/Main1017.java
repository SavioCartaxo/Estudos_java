package Beecrowd;

import java.util.*;

public class Main1017 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int vm = sc.nextInt();

        sc.close();

        int s = t * vm;

        double ql = s / 12.0;

        System.out.printf("%.3f\n", ql);
    }
}
