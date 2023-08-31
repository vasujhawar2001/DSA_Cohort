import heapq

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        hashMap = {}
        max_heap = []
        
        # Create a max heap of scores
        for num in score:
            heapq.heappush(max_heap, -num)
        
        # Assign medals based on rank
        res = 1
        while max_heap:
            topEle = -heapq.heappop(max_heap)
            if res == 1:
                hashMap[topEle] = "Gold Medal"
            elif res == 2:
                hashMap[topEle] = "Silver Medal"
            elif res == 3:
                hashMap[topEle] = "Bronze Medal"
            else:
                hashMap[topEle] = str(res)
            res += 1
        
        # Create the result list with correct order
        ans = []
        for num in score:
            ans.append(hashMap[num])
        return ans


