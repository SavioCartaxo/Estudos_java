import java.util.*;

public class SelectionSort{
        
    public void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int menor = i;

            for (int j = i+1; j < v.length; j++) {
                if (v[menor] > v[j]) {
                    menor = j;
                }
            }

            int descarte = v[i];
            v[i] = v[menor];
            v[menor] = descarte;
        }
    }

    public static void main(String[] args) {
        int[] arr= {10, 22, 3, 1, 53, 2, 5, 7, 38, 98};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}