import java.util.*;

//1658. Minimum Operations to Reduce X to Zero
//        You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
//        Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
//        Example 1:
//        Input: nums = [1,1,4,2,3], x = 5
//        Output: 2
//        Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
//        Example 2:
//        Input: nums = [5,6,7,8,9], x = 4
//        Output: -1
//        Example 3:
//        Input: nums = [3,2,20,1,1,3], x = 10
//        Output: 5
//        Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
//        https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/description/?envType=daily-question&envId=2023-09-20
public class LeetCode1658 {

    //DP solution TC - O(N^2) SC - O(N^2)
    public static int dp(int left, int right, int[] nums, int target, Integer[][] dp){

        if(target==0){
            return 0;
        }

        if(left>right || target<0){
            //
            return Integer.MAX_VALUE-1;
        }

        if(dp[left][right]!=null){
            return dp[left][right];
        }

        int take_left = 1 + dp(left+1, right, nums, target-nums[left], dp);
        int take_right = 1 + dp(left, right-1, nums, target-nums[right], dp);

        // take min of both of them
        return dp[left][right] = Math.min(take_left, take_right);
    }
    // Better Approach 2
    // If it exists an answer, then it means we have a subarray in the middle of original array whose sum is == totalSum - x
    // If we want to minimize our operations, then we should maximize the length of the middle subarray. Then the qeustion becomes: Find the Longest Subarray with Sum Equals to TotalSum - X We could simply use Map + Prefix Sum to get it!

    public int minOperations(int[] nums, int x) {

        int totalsum = 0;
        for(int num: nums){
            totalsum += num;
        }
        int target = totalsum - x;
        if(target==0){
            return nums.length; // we have to remove all
        }
        Map<Integer, Integer> map = new HashMap<>(); // prefixSum and indeex
        map.put(0, -1);
        int maxOp = -1;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - target))
                maxOp = Math.max(maxOp, i - map.get(prefixSum - target));
            map.put(prefixSum, i);
        }
        if (maxOp == -1)
            return -1;
        else
            return nums.length - maxOp;
    }

    //sliding window
    public int minOperations2(int[] nums, int x){
        int totalsum = 0;
        for(int num: nums){
            totalsum += num;
        }
        int target = totalsum - x;
        int curr_sum=0;
        int max_window = -1;
        int left=0, right=0;
        while(right<nums.length){
            curr_sum += nums[right];

            while(left<=right && curr_sum>target){
                curr_sum -= nums[left];
                left++;
            }

            if(curr_sum==target){
                max_window = Math.max(max_window, right-left+1); // found potential ans
            }
            right++;
        }

        return max_window==-1?-1: nums.length - max_window;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,20,1,1,3};
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        int target = 10;
        int ans = dp(0, n-1, nums, target, dp);
        if(ans>=1e9) ans =-1;
        System.out.println(ans);
    }
}
