
<h1>Merge k Sorted Lists</h1>
<p>Leetcode link https://leetcode.com/problems/merge-k-sorted-lists/ </p>
<section>
<p>You are given an array of k linked-lists lists, each linked-list is sorted in ascending order. <br>
Merge all the linked-lists into one sorted linked-list and return it.
</p>
<div>
<h2>Example 1:</h2>
<p>
Input: lists = [[1,4,5],[1,3,4],[2,6]] <br>
Output: [1,1,2,3,4,4,5,6]<br>
Explanation: The linked-lists are:<br>
<br>
[
<br>
  1->4->5,
<br>
  1->3->4,
<br>
  2->6
<br>
]
<br>
merging them into one sorted list:
<br>
1->1->2->3->4->4->5->6
<br>
</div>
<div>
<h3>Constraints:</h3>
<p>
k == lists.length <br>
0 <= k <= 10^4<br>
 
0 <= lists[i].length <= 500 <br>
-10^4 <= lists[i][j] <= 10^4<br>
 
lists[i] is sorted in ascending order<br>
The sum of lists[i].length will not exceed 10^4.<br>
</p>
</div>

</section>

<section> 
<h1> Python Solution</h1>

<p>
The code uses a min-heap (a priority queue) to efficiently merge multiple linked lists. <br>
It goes through each linked list in the input lists and adds the values from each list to the min-heap.<br>
Then, it creates a new linked list by repeatedly extracting the smallest value from the min-heap and linking the nodes in sorted order.<br>
Finally, the merged linked list is returned.<br>
Space Complexity:<br>

The min-heap stores at most N values (where N is the total number of elements across all input linked lists). So, the space complexity is O(N).<br>
Time Complexity:<br>

The code goes through all the elements in the input linked lists once and adds them to the min-heap. This takes O(N * log K) time, where K is the <br>number of linked lists and N is the average number of nodes in each linked list.<br>
Creating the merged linked list by extracting values from the min-heap also takes O(N * log K) time.<br>
Overall, the time complexity is O(N * log K).<br>
Keep in mind that understanding the heapq library and linked lists concepts helps in grasping this code better.<br>






