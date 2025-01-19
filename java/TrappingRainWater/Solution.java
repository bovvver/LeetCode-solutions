// You are given an array non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
// Return the maximum area of water that can be trapped between the bars.

// Example 1:
// Input: height = [0,2,0,3,1,0,1,3,2,1]
// Output: 9

class Solution {
    public int trap(int[] height) {
        int result = 0;

        for(int i = 1; i < height.length - 1; i++) {
            int l = 0, r = height.length - 1, prefix = 0, sufix = 0;

            while(l < i) {
                if(height[l] > prefix) prefix = height[l];
                l++;
            }
            while(r > i) {
                if(height[r] > sufix) sufix = height[r];
                r--;
            }
            
            int sum = Math.min(prefix, sufix) - height[i];
            if(sum > 0) result += sum;
        }
        return result;
    }
}
