package linkedList;

// Java program for reversing the linked list

import java.util.LinkedList;
import java.util.Stack;

class ReverseSingleLinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Function to reverse the linked list */
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // Recursive function to reverse a given linked list. It reverses the
    // given linked list by fixing the head pointer and then `.next`
    // pointers of every node in reverse order
    public static Node recursiveReverse(Node curr, Node prev, Node head)
    {
        // base case: end of the list reached
        if (curr == null) {
            // fix head pointer
            head = prev;
            return head;
        }

        // recur for the next node and pass the current node as a previous node
        head = recursiveReverse(curr.next, curr, head);

        // fix current node (nodes following it are already fixed)
        curr.next = prev;

        return head;
    }

    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curr, Node prev)
    {
        /*If head is initially null OR list is empty*/
        if (head == null)
            return head;
        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;

            return head;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }

    // linked list
    static void reverseLLUsingStack()
    {

        // Create a stack "s"
        // of Node type
        Stack<Node> s = new Stack<>();
        Node temp = head;
        while (temp.next != null)
        {

            // Push all the nodes
            // in to stack
            s.add(temp);
            temp = temp.next;
        }
        head = temp;

        while (!s.isEmpty())
        {

            // Store the top value of
            // stack in list
            temp.next = s.peek();

            // Pop the value from stack
            s.pop();

            // update the next pointer in the
            // in the list
            temp = temp.next;
        }
        temp.next = null;
    }

    // prints content of double linked list
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        ReverseSingleLinkedList list = new ReverseSingleLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }
}