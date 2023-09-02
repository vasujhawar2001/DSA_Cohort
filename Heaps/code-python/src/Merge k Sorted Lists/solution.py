from typing import List
import heapq

class SinglyLinkedListNode:
    def __init__(self, data: int = None, next = None) -> None:
        self.data = data
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[SinglyLinkedListNode]) -> SinglyLinkedListNode:
        min_heap = []
        for row in lists:
            root = row
            while root is not None:
                val = root.data
                heapq.heappush(min_heap, val)
                root = root.next
        
        dummy = SinglyLinkedListNode()
        curr = dummy
        while min_heap:
            val = heapq.heappop(min_heap)
            curr.next = SinglyLinkedListNode(val)
            curr = curr.next
        
        return dummy.next