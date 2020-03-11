package linkedList;

// Data Structure to store a linked list LinkedListNode
class LinkedListNode {
    char data;
    LinkedListNode next;

    LinkedListNode(char ch) {
        this.data = ch;
        this.next = null;
    }
};


public class IsPalindrome {


    // Construct String s1 and s2 out of given linked list with consecutive
    // elements of the list in forward and backward direction respectively
    public static void construct(LinkedListNode head, StringBuilder s1, StringBuilder s2) {
        // Base case
        if (head == null) {
            return;
        }

        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(head.data);
    }

    // Function to check if a given linked list of characters is palindrome
    public static boolean isPalindrome(LinkedListNode head) {
        // construct String s1 and s2 with consecutive elements of the linked list
        // starting from the beginning and the end respectively

        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);

        // check if linked list is palindrome
        return s1.toString().equals(s2.toString());
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode('A');
        head.next = new LinkedListNode('B');
        head.next.next = new LinkedListNode('C');
        head.next.next.next = new LinkedListNode('B');
        head.next.next.next.next = new LinkedListNode('A');

        if (isPalindrome(head)) {
            System.out.print("Linked List is a palindrome.");
        } else {
            System.out.print("Linked List is not a palindrome.");
        }
    }

}
