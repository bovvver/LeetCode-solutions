// Design a stack class that supports the push, pop, top, and getMin operations.

//     MinStack() initializes the stack object.
//     void push(int val) pushes the element val onto the stack.
//     void pop() removes the element on the top of the stack.
//     int top() gets the top element of the stack.
//     int getMin() retrieves the minimum element in the stack.

// Each function should run in O(1)O(1) time.

// Example 1:
// Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
// Output: [null,null,null,null,0,null,2,1]

// Explanation:
// MinStack minStack = new MinStack();
// minStack.push(1);
// minStack.push(2);
// minStack.push(0);
// minStack.getMin(); // return 0
// minStack.pop();
// minStack.top();    // return 2
// minStack.getMin(); // return 1

class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minimums;

    public MinStack() {
        values = new Stack<>();
        minimums = new Stack<>();
    }
    
    public void push(int val) {
        values.push(val);

        if(minimums.isEmpty() || minimums.peek() >= val) minimums.push(val);
    }
    
    public void pop() {
        if(values.isEmpty()) return;
        int poppedValue = values.pop();
        if(poppedValue == minimums.peek()) minimums.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return minimums.peek();
    }
}
