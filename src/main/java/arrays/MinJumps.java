package arrays;

public class MinJumps {

        static int jump(int[] A) {
            if (A.length <= 1)
                return 0;
            int maxReach = A[0];
            int step = A[0];
            int jump = 1;
            for (int i = 1; i < A.length; i++) {
                if (i == A.length - 1)
                    return jump;
                if (i + A[i] > maxReach)
                    maxReach = i + A[i];
                step--;
                if (step == 0) {
                    jump++;
                    step = maxReach - i;
                }
            }
            return jump;
        }


    public static void main(String[] args) {
            int[] a = {2,3,1,1,4};

            int jumps = jump(a);

        System.out.println("Minimum no. of jumps : " + jumps);
    }
}
