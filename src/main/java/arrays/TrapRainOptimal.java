package arrays;

public class TrapRainOptimal {

        // Function to find amount of water that can be trapped within
        // given set of bars in linear time and constant space
        public static int trap(int[] heights)
        {
            // maintain two pointers left and right pointing to leftmost and
            // rightmost index of the input array
            int left = 0, right = heights.length - 1, water = 0;

            int maxLeft = heights[left];
            int maxRight = heights[right];

            while (left < right)
            {
                if (heights[left] <= heights[right])
                {
                    left++;
                    maxLeft = Integer.max(maxLeft, heights[left]);
                    water += (maxLeft - heights[left]);
                }
                else
                {
                    right--;
                    maxRight = Integer.max(maxRight, heights[right]);
                    water += (maxRight - heights[right]);
                }
            }

            return water;
        }


    static int findWater(int arr[], int n)
    {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }

        // Trapping Rain Water within given set of bars
        public static void main(String[] args)
        {
            int[] heights = {7,0,2,4};

            System.out.print("Maximum amount of water that can be trapped is " +
                    trap(heights));
        }


}
