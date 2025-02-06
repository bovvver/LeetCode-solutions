// You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.

// Example 1:
// Input: n = 1
// Output: ["()"]

// Example 2:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

// You may return the answer in any order.

class Solution {
    private void backtrack(
        int openCounter, 
        int closedCounter, 
        List<String> res,
        StringBuilder current,
        int n
        ) {
            if(openCounter == closedCounter && current.length() == 2 * n) {
                res.add(current.toString());
                return;
            }
            if(openCounter < n) {
                current.append("(");
                backtrack(openCounter + 1, closedCounter, res, current, n);
                current.deleteCharAt(current.length() - 1);
            }
            if(closedCounter < openCounter) {
                current.append(")");
                backtrack(openCounter, closedCounter + 1, res, current, n);
                current.deleteCharAt(current.length() - 1);
            }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder current = new StringBuilder();
        backtrack(0, 0, res, current, n);
        return res;
    }
}
