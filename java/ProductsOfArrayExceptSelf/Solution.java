// Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
// Each product is guaranteed to fit in a 32-bit integer.
// Follow-up: Could you solve it in O(n)O(n) time without using the division operation?

// Example 1:
// Input: nums = [1,2,4,6]
// Output: [48,24,12,8]

// Example 2:
// Input: nums = [-1,0,1,2,3]
// Output: [0,-6,0,0,0]

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] result = new int[numsLength];

        result[0] = 1;
        for(int i = 1; i < numsLength; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for(int i = numsLength - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}  
