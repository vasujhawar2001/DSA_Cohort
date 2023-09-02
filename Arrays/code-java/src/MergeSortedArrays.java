package com.vasu;

public class MergeSortedArrays {
    public int[] merge(int[] nums1, int[] nums2){
		int k = 0;
		int[] merged = new int[nums1.length+nums2.length];
		int i=0, j=0;
		for(; i<nums1.length && j<nums2.length;){
			if(nums1[i]<nums2[j]){
				merged[k]=nums1[i];
				i++;
			}
			else{
				merged[k]=nums2[j];
				j++;
			}
			k++;
		}
		while(i<nums1.length){
				merged[k]=nums1[i];
				i++;
				k++;
			}
		while(j<nums2.length){
				merged[k]=nums2[j];
				j++;
				k++;
			}
			return merged;
	}
}
