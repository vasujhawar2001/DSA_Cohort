class Solution:
    def max_subarray(nums):
        max_current = max_global = nums[0]
        start = end = 0
        temp_start = 0

        for i in range(1, len(nums)):
            if nums[i] > max_current + nums[i]:
                max_current = nums[i]
                temp_start = i
            else:
                max_current += nums[i]

            if max_current > max_global:
                max_global = max_current
                start = temp_start
                end = i

        return start, end, max_global