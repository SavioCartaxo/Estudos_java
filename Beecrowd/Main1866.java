package Beecrowd;

import java.util.*;

public class Main1866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int[] l = new int[t];

        for (int i = 0; i < t; i++) {
            
            l[i] = sc.nextInt();
            
            if (l[i] % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

        sc.close();

    }
}
