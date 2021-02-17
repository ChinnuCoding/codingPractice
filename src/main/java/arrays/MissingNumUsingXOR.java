package arrays;

class MissingNumUsingXOR
{
    // Find the missing number in a given array
    public static int getMissingNumber(int[] arr)
    {
        // Compute XOR of all the elements in the array
        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }

        // Compute XOR of all the elements from 1 to `n+1`
        for (int i = 1; i <= arr.length + 1; i++) {
            xor = xor ^ i;
        }

        return xor;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 7, 8, 9, 10 };

        System.out.println("The missing number is " + getMissingNumber(arr));
    }
}
