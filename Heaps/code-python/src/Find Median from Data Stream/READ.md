<h1>
DescriptionDescription
SolutionSolution
SubmissionsSubmissions
Find Median from Data Stream</h1>
<section>
<h3>The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
</h3>
<h4>
Example 1:

Input: 
 ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 [[], [1], [2], [], [3], []]Output: [null, null, null, 1.50000, null, 2.00000]
Explanation: MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1); // arr = [1]

medianFinder.addNum(2); // arr = [1, 2]

medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)

medianFinder.addNum(3); // arr[1, 2, 3]

medianFinder.findMedian(); // return 2.0

Constraints:

-
1
0
5
10 
5
 <= num <= 
1
0
5
10 
5
 
There will be at least one element in the data structure before calling findMedian.
At most 5 * 
1
0
4
10 
4
  calls will be made to addNum and findMedian.
  </h4>
</section>
<section>
<h2> Solution appraoch </h2>
<p>This code defines a class called "MedianFinder" that helps keep track of a list of numbers and efficiently calculates the median of those numbers. <br>

Here's what the code does: <br>

1. It uses two heaps: a max heap and a min heap. These heaps are data structures that help maintain the largest elements in the max heap and the smallest elements in the min heap.<br>

2. When a number is added using the `addNum` method:
   - The negative of the number is inserted into the max heap. This is because Python's heapq library only supports min heaps, so using the negative values effectively creates a max heap.
   - The largest element (negative) is removed from the max heap.
   - This removed element is then inserted into the min heap.
   - If the max heap has fewer elements than the min heap, the smallest element from the min heap is removed and inserted back into the max heap. <br>

3. The `findMedian` method:
   - If the number of elements in the max heap is the same as in the min heap, it means there's an even number of elements. The median is calculated by taking the average of the largest element in the max heap (negated) and the smallest element in the min heap. <br>
   - If the number of elements is odd, the largest element in the max heap (negated) is the median.<br>

<h3>Space Complexity:</h3>
<p>
- The space used is proportional to the number of elements in the max and min heaps combined. So, it's O(N), where N is the number of elements.
</p>

<h3>Time Complexity:</h3>
<p>
- Adding a number using `addNum`: O(log N), where N is the total number of elements.
- Calculating the median using `findMedian`: O(1).

In simple terms, this code provides a clever way to maintain two heaps to efficiently find the median of a growing list of numbers. The operations for adding a number and finding the median are both quite efficient.
</p>

</section>