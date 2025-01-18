// You are given an integer array heights where heights[i] represents the height of the ithith bar.

// You may choose any two bars to form a container. Return the maximum amount of water a container can store.

// Example 1:
// Input: height = [1,7,2,5,4,7,3,6]
// Output: 36

// Example 2:
// Input: height = [2,2,2]
// Output: 4

  class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;

        while(l < r) {
            int res = (r - l) * Math.min(heights[r], heights[l]);
            if(res > maxArea) maxArea = res;
            if(heights[r] < heights[l]) r--;
            else l++;
        }
        return maxArea;
    }
}
