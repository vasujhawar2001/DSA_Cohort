import heapq
class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        min_heap = []
        ans = []
        for i in range(len(mat)):
            arr = mat[i]
            temp = []
            temp.append(self.countOne(arr))
            temp.append(i)
            heapq.heappush(min_heap,temp)
        while(k):
            res = heapq.heappop(min_heap)
            ans.append(res[1])
            k-=1
        return ans
    def countOne(self,arr):
        a = 0
        for k in arr:
            if(k==1):
                a+=1
        return a
