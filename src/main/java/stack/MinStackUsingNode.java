package stack;

import java.util.Stack;

class MinStackUsingNode {

    // each node in stack will store the minimum there has been so far
    public class Node {
        int val;
        int min;
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Node> stack = new Stack<Node>();

    /** initialize your data structure here. */
    public MinStackUsingNode() {
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
            return;
        }
        // compare with current min
        int min = Math.min(stack.peek().min, x);
        stack.push(new Node(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}