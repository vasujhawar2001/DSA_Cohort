<section>
<h1>Problem Statement</h1>
<h2> Link fo the problem </h2>
<a href="https://www.codingninjas.com/studio/problems/walls-and-gates_1092887?topList=nishant-chahar-sde-sheet-problems&leftPanelTab=0">Walls and Gates</a>
</section>
<section>
<h1>Explanation for Python Solution</h1>
<p>
This code is for solving a problem related to finding the shortest distance from specific points in a 2D grid to a set of target points. It uses a recursive depth-first search (DFS) approach. Here's a breakdown of the code:</p>

<p>1. `helper` function:
   - This function takes several parameters:
     - `a`: a 2D grid (represented as a list of lists).
     - `row` and `col`: the current row and column indices in the grid.
     - `var`: a variable that represents the distance traveled from the starting point.
     - `n` and `m`: the dimensions of the grid.
   - The function is called recursively to explore the grid.
   - If the current position is out of bounds (row or column index is less than 0 or greater than or equal to `n` or `m`) or if the value at the current position `a[row][col]` is greater than the new `var` value, the function returns without doing anything.
   - Otherwise, it updates the value at `a[row][col]` with the new `var` value and explores the adjacent cells (up, right, down, left) by recursively calling itself with incremented `var` values.

2. `wallsAndGates` function:
   - This function is the entry point for the problem.
   - It takes three parameters:
     - `a`: the 2D grid representing the maze.
     - `n`: the number of rows in the grid.
     - `m`: the number of columns in the grid.
   - It iterates through the entire grid using two nested loops.
   - When it encounters a cell with the value 0 (indicating a starting point), it calls the `helper` function to perform DFS from that point.
   - After the loop finishes, the function returns the modified grid `a`.</p>

<h3>Time Complexity:</h3>
- The time complexity of this code is O(n * m), where n is the number of rows and m is the number of columns in the grid. This is because we explore each cell in the grid exactly once.

<h3>Space Complexity:</h3>
- The space complexity is O(1) because we are not using any additional data structures that grow with the input size. The recursion stack does contribute to space usage, but it's limited by the depth of the recursion, which is at most O(n * m) in the worst case (when all cells are reachable from the starting points).
</section>