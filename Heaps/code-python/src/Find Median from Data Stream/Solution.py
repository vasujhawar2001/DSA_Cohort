import heapq

class MedianFinder:
    def __init__(self):
        self.min_heap = []
        self.max_heap = []

    def addNum(self, num: int):
        # Your code goes here
        # for creating max_heap in python just insert val with negative sign
        # while poping the elements pop with negative sign 
        """add ele into left 
            pop from left then add into right
            if len(left)<len(right) pop from right, then add it to left
        """
        heapq.heappush(self.max_heap,-num)
        ele = -heapq.heappop(self.max_heap)
        # adding the right heap
        heapq.heappush(self.min_heap,ele)
        if(len(self.max_heap)<len(self.min_heap)):
            ele1 = heapq.heappop(self.min_heap)
            heapq.heappush(self.max_heap,-ele1)

    def findMedian(self) -> float:
        if(len(self.max_heap)==len(self.min_heap)):
            right = -(self.max_heap[0])
            left = self.min_heap[0]
            return (right+left)/2
        else:
            return -(self.max_heap[0])