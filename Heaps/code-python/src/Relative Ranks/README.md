<section>
<h1>Relative Ranks</h1>
<h2>Problem Statement</h2>
<h3> Leetcode link </h3> 
<a href="https://leetcode.com/problems/relative-ranks/"> Relative Rank of a Number </a><br />
<p>You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All <br>
thescores are guaranteed to be unique.<br>

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has <br>
the 2nd highest score, and so on. The placement of each athlete determines their rank: <br>

The 1st place athlete's rank is "Gold Medal". <br>
The 2nd place athlete's rank is "Silver Medal". <br>
The 3rd place athlete's rank is "Bronze Medal". <br>
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x"). <br>
Return an array answer of size n where answer[i] is the rank of the ith athlete. <br>
</section>

<section>
<p>
<h4>Example 1:</h4>

Input: score = [5,4,3,2,1] <br>
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]<br>
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].<br>
Example 2:

Input: score = [10,3,8,9,4] <br>
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]<br>
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].<br>


<h3>Constraints:</h3>

n == score.length<br>
1 <= n <= 10^4<br>
 
0 <= score[i] <=10^6<br>
 
All the values in score are unique.<br>
</section>
<section>
<h1> Approach Explation step-by-step</h1>
<p>
This code defines a class `Solution` that contains a method `findRelativeRanks`.This method takes a list of integers </h1>
representing scores and returns a list of strings representing the medals or ranks corresponding to the scores. </h1>

<h3>The steps of the code are as follows:<h3>

1. A dictionary called `hashMap` is created to store the mapping between scores and their corresponding medals or ranks. <br>

2. A max heap (implemented using `heapq`) called `max_heap` is created to store the negative of each score. This is done to simulate a max heap because <br>
Python's `heapq` module provides a min heap by default. <br>

3. The scores are pushed into the max heap with their negatives. This effectively places the highest scores at the top of the heap.<br>

4. The loop iterates over the max heap. Medals or ranks are assigned based on the current rank (starting from 1) and stored in the `hashMap`.<br>

5. After the loop, a result list called `ans` is created.<br>

6. Another loop iterates over the original scores. For each score, the corresponding medal or rank is retrieved from the `hashMap` and appended to the `ans` list.<br>

7. The `ans` list is returned as the final result.<br>

<h2>Time Complexity:</h2> Let n be the number of scores. The main operations in terms of time complexity are inserting n scores into the max heap (O(n log n)) and iterating over n <br>
scores to create the result list (O(n)). Overall, the time complexity is O(n log n) due to the heap operations.<br>

<h2>Space Complexity:</h2>The space complexity involves the `hashMap` (O(n)) and the `max_heap` (O(n)), as well as the `ans` list (O(n)), resulting in a total space complexity of O(n).
</p>
</section>