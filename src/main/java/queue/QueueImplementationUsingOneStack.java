package queue;

import java.util.Stack;

public class QueueImplementationUsingOneStack {

    private Stack<Integer> stack = new java.util.Stack<>();

    public void insert(Integer elem) {
        if (!stack.empty()) {
            Integer topElem = stack.pop();
            insert(elem);
            stack.push(topElem);
        }
        else
            stack.push(elem);
    }

    public Integer remove() {
        return stack.pop();
    }

}

