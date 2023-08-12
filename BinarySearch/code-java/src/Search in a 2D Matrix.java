/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length; // row length
        int n=matrix[0].length; //column length
        
        int row=-1;
        
        // Apply binary search to find the possible row in which the target might exist
        int low=0,high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                row=mid;
                break;
            }
            if(target<matrix[mid][0])
                high=mid-1;
            else
                low=mid+1;
        }
        // If no possible row found, return false
        if(row==-1)
            return false;

        // Apply binary search again to find the target in the possible row
        low=0;high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(matrix[row][mid]==target)
                return true;
            if(matrix[row][mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}

// Time Complexity: O(log(row) + log(columns)) => O(log(row*columns))
// Space Complexity: O(1)