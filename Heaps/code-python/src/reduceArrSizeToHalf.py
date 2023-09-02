class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        size = len(arr)
        freq = {}
        for num in arr:
            freq[num] = freq.get(num,0)+1
        res = []
        for i in freq:
            temp = []
            temp.append(freq[i])
            temp.append(i)
            res.append(temp)
        res.sort(reverse=True)
        curr = 0
        ans = 0
        for num in res:
            curr+= num[0]
            ans+=1
            if(size-curr<=size//2):
                return ans