package linkedList;

import java.util.HashSet;


public class DetectAndRemoveLoop {

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Returns true if the loop is removed from the linked
    // list else returns false.
    static boolean removeLoop(Node h)
    {
        HashSet<Node> s = new HashSet<Node>();
        Node prev = null;
        while (h != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle and we
            // need to remove this cycle so set the next of
            // the previous pointer with null.

            if (s.contains(h)) {
                prev.next = null;
                return true;
            }

            // If we are seeing the node for
            // the first time, insert it in hash
            else {
                s.add(h);
                prev = h;
                h = h.next;
            }
        }

        return false;
    }


    // Function that detects loop in the list
    void detectAndRemoveLoop(Node node)
    {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        Node slow = node, fast = node;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }
    }


}
