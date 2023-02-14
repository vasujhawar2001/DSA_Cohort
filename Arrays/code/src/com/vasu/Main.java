package com.vasu;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MergeSortedArrays obj = new MergeSortedArrays();
        int[] first = {1,2,3,4,5};
        int[] sec = {6,7,8,9,10};
        int[] ans = obj.merge(first,sec);
        System.out.println(Arrays.toString(ans));
    }
}
