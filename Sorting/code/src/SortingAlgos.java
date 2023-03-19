import java.util.Arrays;

public class SortingAlgos {
    public static void main(String[] args) {

    }

    public int[] mergeSort(int[] arr, int l, int r) {
        // Your code goes here
        if(arr.length==1)
            return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid), 0, mid);
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length), mid, r);
        return merge(left,right);
    }
    public int[] merge(int[] arr1, int[] arr2){
        int[] mix = new int[arr1.length+arr2.length];
        int i=0, j=0, k=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                mix[k] = arr1[i];
                i++;
            }
            else{
                mix[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<arr1.length){
            mix[k] = arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            mix[k] = arr2[j];
            k++;
            j++;
        }
        return mix;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, left, i-1);
        return i-1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
