package com.vasu;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        // int max=nums[0];
        // for(int i=0; i<nums.length;i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         int temp_sum=0;
        //         for(int start=i; start<=j;start++){
        //             temp_sum+=nums[start];
        //         }
        //         max = Math.max(max,temp_sum);
        //     }
        //     max = Math.max(max, nums[i]);
        // }
        // return max;

        // kadane algorithm below:
        // youtube link : https://www.youtube.com/watch?v=86CQq3pKSUw

        int c_max=nums[0];
        int g_max=nums[0];
        for(int i=1; i<nums.length;i++){
            c_max= Math.max(nums[i], c_max+nums[i]);
            if(c_max>g_max){
                g_max=c_max;
            }
        }
        return g_max;
    }
}
