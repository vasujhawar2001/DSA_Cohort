package com.vasu;

import java.util.*;

public class Questions {
    public static void main(String[] args) {
        int[] nums = {10,4,2,20,40,12,6};
        int [] ans = nextSmallerElement(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] nextSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>(); // we will store indices in stack
        //push the index in stack while it is greater
        int i=0;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        while(i<nums.length){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                //pop from stack and update ans[]
                ans[stack.pop()] = nums[i];
            }
            //push to stack
            stack.push(i);
            i++;
        }
        return ans;
    }

    public static int[] previousGreaterElement(int[] arr) {
        // Your code goes here
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        //traverse in reverse direction
        for(int i=arr.length-1; i>=0; i--){

            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                //pop from the stack and update ans arrray
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
