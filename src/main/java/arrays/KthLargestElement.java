package arrays;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] a = {20,3,10,5,1};
        int kthLargest = findKthLargest(a, 1);
        System.out.println("Kth Largest element using heap sort: " + kthLargest);
    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                System.out.println("deleted  :" + q.poll());
            }
        }

        return q.peek();
    }
}
