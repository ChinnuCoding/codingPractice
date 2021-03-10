package queue;

import java.util.Stack;

public class QueueImplementationUsingTwoStacks
{

    private Stack<Integer> inbox = new Stack<>();
    private Stack<Integer> outbox = new Stack<>();

    public void queue(Integer item) {
        inbox.push(item);
    }

    public Integer dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }

}

class Queue
{
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    static void enQueue(int x)
    {
        // Move all elements from s1 to s2
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());
            //s1.pop();
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
            //s2.pop();
        }
    }

    // Dequeue an item from the queue
    static int deQueue()
    {
        // if first stack is empty
        if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        // Return top of s1
        int x = s1.peek();
        s1.pop();
        return x;
    }
};