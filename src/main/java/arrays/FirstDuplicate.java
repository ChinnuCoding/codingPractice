package arrays;

public class FirstDuplicate {

    public static void main(String[] args) {
        int arr[] = {1,4,6,2,4,5,1};

        int element = findDuplicate(arr);

        System.out.println("First duplicate element is : " + element);
    }

    static int findDuplicate(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[Math.abs(arr[i])-1] < 0) {
                return Math.abs(arr[i]);
            } else {
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }
        }

        return -1;
    }

}
