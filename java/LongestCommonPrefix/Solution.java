// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int minLength = Math.min(commonPrefix.length(), strs[i].length());
            StringBuilder newPrefix = new StringBuilder();

            for (int j = 0; j < minLength; j++) {
                if (commonPrefix.charAt(j) == strs[i].charAt(j))
                    newPrefix.append(commonPrefix.charAt(j));
                else break;
            }
            commonPrefix = newPrefix.toString();
        }
        return commonPrefix;
    }
}