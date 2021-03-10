package linkedList;

import java.util.HashSet;
import java.util.Set;

// A linked list node
class DetectCycleNode {
    int data;
    DetectCycleNode next;

    DetectCycleNode(int data, DetectCycleNode next) {
        this.data = data;
        this.next = next;
    }
};

public class DetectCycle {

    // Function to detect Cycle in a linked list using Hashing
    public static boolean detectCycle(DetectCycleNode head) {
        DetectCycleNode curr = head;
        Set<DetectCycleNode> set = new HashSet();

        // traverse the list
        while (curr != null) {
            // return false if we already have seen this node before
            if (set.contains(curr)) {
                return true;
            }

            // insert current node into the set
            set.add(curr);

            // move to the next node
            curr = curr.next;
        }

        // we reach here if list does not contain any cycle
        return false;
    }

    // Function to detect Cycle in a linked list using
    // Floyd’s Cycle Detection Algorithm
    public static boolean detectCycleUsingFloydAlgo(Node head)
    {
        // take two references - slow and fast
        Node slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            // move slow by one
            slow = slow.next;

            // move fast by two
            fast = fast.next.next;

            // if they meet any any node, linked list contains a cycle
            if (slow == fast) {
                return true;
            }
        }

        // we reach here if slow & fast do not meet
        return false;
    }

    static class LoopNode
    {
        int data;
        LoopNode next;
        int flag;
    };

    // Returns true if there is a loop in linked
// list else returns false.
    static boolean detectLoopUsingFlag(LoopNode h)
    {
        while (h != null)
        {

            // If this node is already traverse
            // it means there is a cycle
            // (Because you we encountering the
            // node for the second time).
            if (h.flag == 1)
                return true;

            // If we are seeing the node for
            // the first time, mark its flag as 1
            h.flag = 1;

            h = h.next;
        }
        return false;
    }

    // Detect Cycle in a linked list
    public static void main(String[] args) {
        // input keys
        int[] keys = {1, 2, 3, 4, 5};

        DetectCycleNode head = null;
        for (int i = keys.length - 1; i >= 0; i--)
            head = new DetectCycleNode(keys[i], head);

        // insert cycle
        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }
    }

}
