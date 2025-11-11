import java.util.*;

public class InsertionSort{

    public void insertionSort(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                
                if (arr[j-1] > arr[j]) {
                    int troca = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = troca;
                }
                
            }
        }
    }

    public static void main(String[] args) {
        int[] arr= {10, 22, 3, 1, 53, 2, 5, 7, 38, 98};
        InsertionSort ss = new InsertionSort();
        ss.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}