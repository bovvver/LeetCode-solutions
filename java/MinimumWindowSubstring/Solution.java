// Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
// You may assume that the correct output is always unique.

// Example 1:
// Input: s = "OUZODYXAZV", t = "XYZ"
// Output: "YXAZ"
// Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

// Example 2:
// Input: s = "xyz", t = "xyz"
// Output: "xyz"

// Example 3:
// Input: s = "x", t = "xy"
// Output: ""

class Solution {
    public String minWindow(String s, String t) {
    Map<Character, Integer> haveMap = new HashMap<>();
    Map<Character, Integer> needMap = new HashMap<>();

    for (char c : t.toCharArray()) {
        needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        haveMap.put(c, 0);
    }

    int haveCounter = 0, needCounter = needMap.keySet().size();
    int startPointer = 0, endPointer = 0;
    String result = "";

    while (endPointer < s.length()) {
        char sChar = s.charAt(endPointer);
        if (needMap.containsKey(sChar)) {
            haveMap.put(sChar, haveMap.get(sChar) + 1);
            if (haveMap.get(sChar).equals(needMap.get(sChar))) {
                haveCounter++;
            }
        }
        endPointer++;

        while (haveCounter == needCounter) {
            String current = s.substring(startPointer, endPointer);
            if (result.isEmpty() || current.length() < result.length()) {
                result = current;
            }

            char startChar = s.charAt(startPointer);
            if (needMap.containsKey(startChar)) {
                haveMap.put(startChar, haveMap.get(startChar) - 1);
                if (haveMap.get(startChar) < needMap.get(startChar)) {
                    haveCounter--;
                }
            }
            startPointer++;
        }
    }

    return result;
}
}
