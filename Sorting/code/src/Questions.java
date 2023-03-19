import java.util.*;

public class Questions {
    public static void main(String[] args) {
        String[] name = {"surbhi","surpankha","shreya"};
        int[] quotient = {3, 3, 5};
        int k = 2;
        String[] ans = bestPlayer(name, quotient, k);
        System.out.println(Arrays.toString(ans));
    }

    //https://nextleap.app/course-dashboard/nlcfs7nszcdmm0bs512dc/practice/nlactppqod1jzgqia77i323
    public static String[] bestPlayer(String[] name, int[] arr, int k) {
        // Your code goes here
        String[] ans = new String[k];
        int n = arr.length;
        for(int i=0; i<n;i++){
            for(int j=1; j<n-i;j++){
                if(arr[j]>arr[j-1]){
                    //swap quotirent
                    int t = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=t;
                    //swap name
                    String temp = name[j];
                    name[j]=name[j-1];
                    name[j-1]=temp;
                }
            }
        }

        for(int i=0; i<k;i++){
            if(arr[i]>arr[i+1])
                ans[i]=name[i];
            else{
                if(name[i].compareTo(name[i+1])<0)
                    ans[i]=name[i];
                else
                    ans[i]=name[i+1];
            }
        }
        return ans;
    }

    public long inversionCount(int[] A) {
        long ans= mergeSort(A, 0, A.length-1);
        return ans==0? 0 : ans-1;
    }
    public long mergeSort(int[] arr, int start, int end) {
        // Your code goes here
        if(start==end)
            return 0;
        int mid = (start+end)/2;

        long left = mergeSort(arr, start, mid);
        long right = mergeSort(arr, mid+1, end);

        long curr_ans = merge(arr,start,end); //will give cross inversions
        return left+right+curr_ans;
    }
    public long merge(int[] arr,int start, int end){
        int[] mix = new int[start+end+1];
        int mid = (start+end)/2;
        int i = start;
        int j= mid+1;
        int k=0;
        int ans=0;

        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                mix[k] = arr[i];
                i++;
            }
            else{
                ans+=(mid-i+1);
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            mix[k] = arr[i];
            k++;
            i++;
        }
        while(j<=end){
            mix[k] = arr[j];
            k++;
            j++;
        }
        return ans;
    }
}
