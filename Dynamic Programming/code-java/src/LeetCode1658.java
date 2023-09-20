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
    public static int dp(int left, int right, int[] nums, int target, Integer[][] dp){

        if(target==0){
            return 0;
        }

        if(left>right || target<0){
            //
            return (int)1e9;
        }

        if(dp[left][right]!=null){
            return dp[left][right];
        }

        int take_left = 1 + dp(left+1, right, nums, target-nums[left], dp);
        int take_right = 1 + dp(left, right-1, nums, target-nums[right], dp);

        // take min of both of them
        return dp[left][right] = Math.min(take_left, take_right);
    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,8,9};
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        int target = 4;
        int ans = dp(0, n-1, nums, target, dp);
        if(ans>=1e9) ans =-1;
        System.out.println(ans);
    }
}
