package linkedList;

class FindMiddleNode {

    static Node head;

    // Link list node
    class Node
    {
        int data;
        Node next;

        // Constructor
        public Node(Node next, int data)
        {
            this.data = data;
            this.next = next;
        }
    }

    // Function to get the middle of
// the linked list
    void printMiddle(Node head)
    {
        int count = 0;
        Node mid = head;

        while (head != null)
        {

            // Update mid, when 'count'
            // is odd number
            if ((count % 2) == 1)
                mid = mid.next;

            ++count;
            head = head.next;
        }

        // If empty list is provided
        if (mid != null)
            System.out.println("The middle element is [" +
                    mid.data + "]\n");
    }

    /* Function to print middle of linked list */
    void printMiddleUsingTwoPointers(Node head)
    {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null)
        {
            while (fast_ptr != null && fast_ptr.next != null)
            {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element using two pointers is [" +
                    slow_ptr.data + "] \n");
        }
    }

    void push(Node head_ref, int new_data)
    {

        // Allocate node
        Node new_node = new Node(head_ref, new_data);

        // Move the head to point to the new node
        head = new_node;
    }

    // A utility function to print a
// given linked list
    void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Driver code
    public static void main(String[] args)
    {
        FindMiddleNode findMiddleNode = new FindMiddleNode();

        for(int i = 5; i > 0; i--)
        {
            findMiddleNode.push(head, i);
            findMiddleNode.printList(head);
            findMiddleNode.printMiddle(head);
            findMiddleNode.printMiddleUsingTwoPointers(head);
        }
    }
}
