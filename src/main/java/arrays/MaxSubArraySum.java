package arrays;

public class MaxSubArraySum {

    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0;i<n;i++) {
            currentSum += nums[i];
            if(currentSum > maxSum)
                maxSum = currentSum;

            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

}
