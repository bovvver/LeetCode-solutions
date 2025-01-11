// Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
// Please implement encode and decode

// Example 1:
// Input: ["neet","code","love","you"]
// Output:["neet","code","love","you"]

// Example 2:
// Input: ["we","say",":","yes"]
// Output: ["we","say",":","yes"]

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.equals("0")) return new LinkedList<String>(List.of(""));

        int lengthIndex = 0;
        List<String> decodedString = new LinkedList<String>();

        while(lengthIndex < str.length()) {
            int endOfLength = lengthIndex;

            while (Character.isDigit(str.charAt(endOfLength))) endOfLength++;
            
            int stringLength = Integer.parseInt(str.substring(lengthIndex, endOfLength));

            endOfLength++;

            decodedString.add(str.substring(endOfLength, endOfLength + stringLength));
            lengthIndex = endOfLength + stringLength;
        }

        return decodedString;
    }
}
