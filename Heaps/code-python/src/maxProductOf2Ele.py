import heapq
class Solution:
    def maxProduct(self, nums):
        min_heap = []
        for num in nums:
            heapq.heappush(min_heap,num)
            if(len(min_heap)>2):
                heapq.heappop(min_heap)
        ans = 1
        while(len(min_heap)):
            ans*=heapq.heappop(min_heap)-1
        return ans