// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:
// Input: s = "egg", t = "add"
// Output: true

// Example 2:
// Input: s = "foo", t = "bar"
// Output: false

// Example 3:
// Input: s = "paper", t = "title"
// Output: true

// Constraints:
//     1 <= s.length <= 5 * 104
//     t.length == s.length
//     s and t consist of any valid ascii character.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[128];
        int[] tMap = new int[128];

        for(int i=0; i<s.length(); i++){
            if(sMap[s.charAt(i)] != tMap[t.charAt(i)]) return false;

            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }
        return true;
    }
}