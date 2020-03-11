package linkedList;

// Data Structure to store a linked list ListNode
class ListNode {
    int data;
    ListNode next;

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
};

public class addTwoLinkedLists {

    // Helper function to print given linked list
    public static void printList(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Iterate through the list and move/insert each ListNode to the
    // front of the out list like a Push of the ListNode
    public static ListNode reverse(ListNode head) {
        ListNode out = null;
        ListNode current = head;

        // traverse the list
        while (current != null) {
            // tricky: note the next ListNode
            ListNode next = current.next;

            // move the current ListNode onto the out
            current.next = out;
            out = current;

            // process next ListNode
            current = next;
        }

        // fix head
        return out;
    }

    // Function to add two lists X and Y
    public static ListNode add(ListNode X, ListNode Y) {
        ListNode head = null;

        // stores last seen ListNode
        ListNode prevNode = null;

        // initialize carry with 0
        int carry = 0;

        // run till both list are empty
        while (X != null || Y != null) {
            // sum is X's data + Y's data + carry (if any)
            int sum = 0;
            if (X != null) {
                sum += X.data;
            }
            if (Y != null) {
                sum += Y.data;
            }
            sum += carry;

            // if sum of 2-digit number, reduce it and update carry
            carry = sum / 10;
            sum = sum % 10;

            // create a new ListNode with calculated sum
            ListNode ListNode = new ListNode(sum, null);

            // if the output list is empty
            if (head == null) {
                // update prev and head to point to the new ListNode
                prevNode = ListNode;
                head = ListNode;
            } else {
                // add new ListNode to the output list
                prevNode.next = ListNode;

                // update prev ListNode to point to the new ListNode
                prevNode = ListNode;
            }

            // advance X and Y for next iteration of the loop
            if (X != null) {
                X = X.next;
            }

            if (Y != null) {
                Y = Y.next;
            }
        }

        if (carry != 0) {
            prevNode.next = new ListNode(carry, prevNode.next);
        }

        return head;
    }

    // Function to add two lists X and Y
    public static ListNode addLists(ListNode X, ListNode Y) {
        // reverse X and Y to access elements from the end
        X = reverse(X);
        Y = reverse(Y);

        return reverse(add(X, Y));
    }

    public static void main(String[] args) {
        int x = 5734;
        int y = 946;

        // construct list X (5 -> 7 -> 3 -> 4) from number x
        ListNode X = null;
        while (x != 0) {
            X = new ListNode(x % 10, X);
            x = x / 10;
        }

        // construct list Y (9 -> 4 -> 6) from number y
        ListNode Y = null;
        while (y != 0) {
            Y = new ListNode(y % 10, Y);
            y = y / 10;
        }

        printList(addLists(X, Y));
    }

}
