// Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
// An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

// Example 1:
// Input: strs = ["act","pots","tops","cat","stop","hat"]
// Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

// Example 2:
// Input: strs = ["x"]
// Output: [["x"]]

// Example 3:
// Input: strs = [""]
// Output: [[""]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> resultList = new ArrayList<>();

            for (int i = 0; i < strs.length; i++) {
                boolean listFound = false;
                for (int j = 0; j < resultList.size(); j++) {
                    if (isAnagram(strs[i], resultList.get(j).get(0))) {
                        resultList.get(j).add(strs[i]);
                        listFound = true;
                        break;
                    }
                }
                if(!listFound)
                    resultList.add(new LinkedList<>(List.of(strs[i])));
            }
            return resultList;
        }

        private boolean isAnagram(String s1, String s2) {
            if (s1.length() != s2.length()) return false;

            int[] count = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }

            for (int value : count)
                if (value != 0) return false;

            return true;
        }
}
