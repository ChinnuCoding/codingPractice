package logical;

public class PowerOfTwo {

    static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    static boolean isPowerOfTwoUsingBitTechnique(int x)
    {
        /* First x in the below expression is
        for the case when x is 0 */
        return x != 0 && ((x & (x - 1)) == 0);
    }

    // Driver program
    public static void main(String args[])
    {
        if (isPowerOfTwo(31))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (isPowerOfTwo(64))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
