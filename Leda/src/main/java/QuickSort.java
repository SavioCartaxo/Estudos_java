import java.util.*;

public class QuickSort{

    // Lomuto
    public void quickSort(int[] arr, int inicio, int fim){
        if (inicio < fim) {
            int p = particionamento(arr, inicio, fim);
            quickSort(arr, inicio, p-1);
            quickSort(arr, p+1, fim);
        }
    }

    public int particionamento(int[] arr, int inicio, int fim){
        int pivot = arr[inicio];
        int i = inicio;

        for (int j = inicio + 1; j <= fim; j++) {
            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, i, inicio);
        return i;
    }

    public void swap(int[] arr, int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 3, 1, 53, 2, 5, 7, 38, 98};
        QuickSort ss = new QuickSort();
        ss.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}