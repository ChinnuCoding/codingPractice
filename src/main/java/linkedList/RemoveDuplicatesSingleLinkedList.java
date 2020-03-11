package linkedList;

import java.util.HashSet;
import java.util.Set;

// A linked list UniqueNode
class UniqueNode
{
    int data;
    UniqueNode next;

    UniqueNode(int data, UniqueNode next) {
        this.data = data;
        this.next = next;
    }
};

public class RemoveDuplicatesSingleLinkedList {

        // Helper function to print given linked list
        public static void printList(UniqueNode head)
        {
            UniqueNode ptr = head;
            while (ptr != null) {
                System.out.print(ptr.data + " -> ");
                ptr = ptr.next;
            }
            System.out.println("null");
        }

        // Function to remove duplicates from a sorted list
        public static UniqueNode removeDuplicates(UniqueNode head)
        {
            UniqueNode previous = null;
            UniqueNode current = head;

            // take an empty set to store linked list nodes for future reference
            Set<Integer> set = new HashSet<>();

            // do till linked list is not empty
            while (current != null)
            {
                // if current UniqueNode is seen before, delete it
                if (set.contains(current.data)) {
                    previous.next = current.next;
                    set.remove(current);
                }
                else {
                    // insert current UniqueNode into the set and proceed to next UniqueNode
                    set.add(current.data);
                    previous = current;
                }
                current = previous.next;
            }

            return head;
        }

        // main method to remove remove duplicates from list
        public static void main(String[] args)
        {
            // input keys
            int[] keys = {5, 3, 4, 2, 5, 4, 1, 3};

            // points to the head UniqueNode of the linked list
            UniqueNode head = null;

            // construct linked list
            for (int i = keys.length - 1; i >= 0; i--) {
                head = new UniqueNode(keys[i], head);
            }

            removeDuplicates(head);

            // print linked list
            printList(head);
        }


}
