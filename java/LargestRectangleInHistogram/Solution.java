// You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
// Return the area of the largest rectangle that can be formed among the bars.
// Note: This chart is known as a histogram.

// Example 1:
// Input: heights = [7,1,7,2,2,4]
// Output: 8

// Example 2:
// Input: heights = [1,3,7]
// Output: 7

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, heights[0]});

        for (int i = 1; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] latest = stack.pop();
                maxArea = Math.max(maxArea, latest[1] * (i - latest[0]));
                start = latest[0];
            }
            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] latest = stack.pop();
            maxArea = Math.max(maxArea, latest[1] * (heights.length - latest[0]));
        }
        return maxArea;
    }
}
