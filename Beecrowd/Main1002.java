package Beecrowd;

import java.util.*;

public class Main1002 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        double Raio = sc.nextDouble();
        sc.close();
        
        double Area = 3.14159 * Math.pow(Raio, 2);
        
        System.out.printf("A=%.4f\n", Area);
    }
}
