package arrays;

// Java program to find the element which is greater than
// all left elements and smaller than all right elements.


public class MidElementInArray {

    static int findElement(int[] arr, int n)
    {
        // leftMax[i] stores maximum of arr[0..i-1]
        int[] leftMax = new int[n];
        leftMax[0] = Integer.MIN_VALUE;

        // Fill leftMax[]1..n-1]
        for (int i = 1; i < n; i++) {
            System.out.println(leftMax[i - 1] + " , " + arr[i - 1]);
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }

        // Initialize minimum from right
        int rightMin = Integer.MAX_VALUE;

        // Traverse array from right
        for (int i = n - 1; i >= 0; i--)
        {
            // Check if we found a required element
            if (leftMax[i] < arr[i] && rightMin > arr[i])
                return i;

            // Update right minimum
            rightMin = Math.min(rightMin, arr[i]);
        }

        // If there was no element matching criteria
        return -1;


    }

    static int findPivot(int[] a) {
        int length = a.length;
        int[] leftMax = new int[length];
        int[] rightMin = new int[length];
        leftMax[0] = a[0];
        for(int i=1; i<length; i++) {
            leftMax[i] = leftMax[i-1]>a[i]?leftMax[i-1]:a[i];
        }

        rightMin[length -1] = a[length-1];
        for(int i=length-2; i>0; i--) {
            rightMin[i] = rightMin[i+1]<a[i]?rightMin[i+1]:a[i];
        }


        int position = -1;
        for(int i = 0; i < length; i++) {
            if(leftMax[i] <= rightMin[i]) {
                position = i;
                break;
            }
        }

        return position;
    }

    // Driver code
    public static void main(String args[])
    {
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int n = arr.length;
        /*System.out.println("Index of the element is " +
                findElement(arr, n));
*/
        int position = findPivot(arr);
        System.out.println("Index value : " + position);
    }


}
