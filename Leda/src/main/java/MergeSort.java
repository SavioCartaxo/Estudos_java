import java.util.*;

public class MergeSort{

    public void mergeSort(int[] arr, int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(arr, inicio, meio);
            mergeSort(arr, meio + 1, fim);
            merge(arr, inicio, fim);
        }
    }

    public void merge(int[] arr, int l, int r){

        int tAuxiliar = r - l;
        int[] auxiliar = new int[tAuxiliar + 1];
        for (int i = 0; i <= tAuxiliar; i++) {
            auxiliar[i] = arr[l + i];
        }

        int meioAuxiliar = tAuxiliar / 2;

        int i = 0;
        int j = meioAuxiliar + 1;
        int k = l;

        while (i <= meioAuxiliar && j <= tAuxiliar) {
            
            if (auxiliar[i] <= auxiliar[j]) {
                arr[k++] = auxiliar[i++];
            } else {
                arr[k++] = auxiliar[j++];
            }
        }

        while (i <= meioAuxiliar) {
            arr[k++] = auxiliar[i++];
        }
    }

    public static void main(String[] args){
        int[] arr = {12, 5, 75, 192, 36, 17, 2, 1, 10, 122};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}