// You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
// Return the integer that represents the evaluation of the expression.

//     The operands may be integers or the results of other operations.
//     The operators include '+', '-', '*', and '/'.
//     Assume that division between integers always truncates toward zero.

// Example 1:
// Input: tokens = ["1","2","+","3","*","4","-"]
// Output: 5
// Explanation: ((1 + 2) * 3) - 4 = 5

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> opStack = new Stack<>();

        for(String token : tokens) {
            if(token.matches("-?\\d+")) opStack.push(Integer.parseInt(token));
            else {
                int operationResult = calculate(opStack.pop(), opStack.pop(), token);
                opStack.push(operationResult);
            }
        }
        return opStack.peek();
    }

    private int calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> b + a;
            case "-" -> b - a;
            case "*" -> b * a;
            case "/" -> {
                if (a == 0) throw new ArithmeticException("Cannot divide by zero");
                yield b / a;
            }
            default -> throw new IllegalArgumentException("Unsupported operator: " + operator);
        };
    }
}
