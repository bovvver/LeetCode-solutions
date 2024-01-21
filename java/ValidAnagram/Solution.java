// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
//
// Example 2:
// Input: s = "rat", t = "car"
// Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] array = new int[26];

        for (char sChar : s.toCharArray())
            array[sChar - 'a']++;

        for (char tChar : t.toCharArray())
            array[tChar - 'a']--;

        for (int value : array)
            if (value != 0) return false;

        return true;
    }
}