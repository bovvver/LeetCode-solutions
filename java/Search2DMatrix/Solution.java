// You are given an m x n 2-D integer array matrix and an integer target.

// Each row in matrix is sorted in non-decreasing order.
// The first integer of every row is greater than the last integer of the previous row.
// Return true if target exists within matrix or false otherwise.

// Can you write a solution that runs in O(log(m * n)) time?

// Example 1:
// Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
// Output: true
  
// Example 2:
// Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
// Output: false

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mid = 0, low = 0, high = matrix.length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            int midLastIndex = matrix[mid].length - 1;

            if (target == matrix[mid][midLastIndex] || target == matrix[mid][0]) return true;
            if (target < matrix[mid][0]) high = mid - 1;
            else if (target > matrix[mid][midLastIndex]) low = mid + 1;
            else break;
        }
        int row = mid;
        low = 0;
        high = matrix[row].length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) high = mid - 1;
            else if (matrix[row][mid] < target) low = mid + 1;
        }
        return false;
    }
}
