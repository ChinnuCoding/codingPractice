package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingTwoQueues {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    void push(int data) {
        queue2.add(data);

        while(!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    int pop() {
        if(!queue1.isEmpty()) {
            return queue1.remove();
        } else {
            return -1;
        }
    }

    int popExpensive() {
        if(queue1.isEmpty()) {
            System.out.println("No element");
        }
        while( queue1.size() != 1) {
            queue2.add(queue1.remove());
        }
        int removedElement = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return removedElement;
    }

    void pushCheap(int data) {
        queue1.add(data);
    }


    public static void main(String[] args) {

        StackImplementationUsingTwoQueues stack = new StackImplementationUsingTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("removed element : " + stack.pop());

        System.out.println("removed element : " + stack.pop());

    }
}
