// You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
// Return a list that contains the maximum element in the window at each step.

// Example 1:
// Input: nums = [1,2,1,0,4,2,6], k = 3
// Output: [2,2,4,4,6]

// Explanation: 
// Window position            Max
// ---------------           -----
// [1  2  1] 0  4  2  6        2
//  1 [2  1  0] 4  2  6        2
//  1  2 [1  0  4] 2  6        4
//  1  2  1 [0  4  2] 6        4
//  1  2  1  0 [4  2  6]       6

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> indexes = new LinkedList<>();
        int[] result = new int[len - k + 1];
        int l = 0, r = 0;

        while (r < len) {
            while (!indexes.isEmpty() && nums[indexes.getLast()] < nums[r]) {
                indexes.removeLast();
            }
            indexes.addLast(r);

            if (indexes.getFirst() < l) indexes.removeFirst();

            if (r + 1 >= k) {
                result[l] = nums[indexes.getFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
