# Check out this problem on leetcode at --> https://leetcode.com/problems/maximum-subarray/

class MaxSubArray:
    def maxSubArray(nums):
        max_current = max_global = nums[0]
        for i in range(1, len(nums)):
            max_current = max(nums[i], max_current + nums[i])
            max_global = max(max_global, max_current)
        return max_global