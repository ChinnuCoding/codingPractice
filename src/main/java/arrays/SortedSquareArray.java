package arrays;

import java.util.Arrays;

public class SortedSquareArray {

    public static void main(String[] args) {
        int[] arr = {-3,-1,2,3,5};
        int[] result = sortedSquareArray(arr);

        System.out.println(Arrays.toString(result));
    }

    static int[] sortedSquareArray(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;

        for(int i = arr.length - 1; i >= 0; i--) {

            if(Math.abs(arr[left]) > arr[right]) {
                result[i] = arr[left] * arr[left];
                left++;
            } else {
                result[i] = arr[right] * arr[right];
                right--;
            }
        }

        return result;
    }

}
