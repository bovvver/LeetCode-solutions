// Given a string s, find the length of the longest substring without duplicate characters.
// A substring is a contiguous sequence of characters within a string.

// Example 1:
// Input: s = "zxyzxyz"
// Output: 3
// Explanation: The string "xyz" is the longest without duplicate characters.

// Example 2:
// Input: s = "xxxx"
// Output: 1

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int longest = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            while(charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(i));
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}
