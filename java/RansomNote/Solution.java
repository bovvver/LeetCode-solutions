// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false

// Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false

// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true

class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] alphabet = new int[26];
        
        for(char mLetter : magazine.toCharArray()) 
            alphabet[mLetter - 'a']++;
        
        for(char rLetter : ransomNote.toCharArray()) {
            if(alphabet[rLetter - 'a'] == 0) return false;
            alphabet[rLetter - 'a']--;
        }
        return true;
    }
}