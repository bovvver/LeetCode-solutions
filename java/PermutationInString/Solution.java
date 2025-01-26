// You are given two strings s1 and s2.
// Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
// Both strings only contain lowercase letters.

// Example 1:
// Input: s1 = "abc", s2 = "lecabee"
// Output: true
// Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".

// Example 2:
// Input: s1 = "abc", s2 = "lecaabee"
// Output: false

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int start = 0;
        int end = s1Length - 1;

        while(end < s2.length()) {
            String s2start = String.valueOf(s2.charAt(end - s1Length + 1));
            String s2end = String.valueOf(s2.charAt(end));

            if(s1.contains(s2end) && s1.contains(s2start)) {
                start = end - s1Length + 1;
                
                if(arePermutations(s1, s2.substring(start, end + 1))) return true;
            } 
            end++;
        }
        return false;
    }

    public boolean arePermutations(String s1, String s2) {
        int[] charCount = new int[128];
        
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }
        
        for (int count : charCount) 
            if (count != 0) return false;
        
        return true;
    }
}
