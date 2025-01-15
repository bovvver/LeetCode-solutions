// Given an array of integers numbers that is sorted in non-decreasing order.
// Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.
// There will always be exactly one valid solution.
// Your solution must use O(1)O(1) additional space.

// Example 1:
// Input: numbers = [1,2,3,4], target = 3
// Output: [1,2]
// Explanation:
// The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int startPointer = 0;
        int endPointer = numbers.length - 1;

        while(startPointer < endPointer) {
            if(numbers[startPointer] + numbers[endPointer] > target) endPointer--;
            else if(numbers[startPointer] + numbers[endPointer] < target) startPointer++;
            else return new int[] {startPointer + 1, endPointer + 1};
        }
        return new int[] {-1,-1}; 
    }
}
