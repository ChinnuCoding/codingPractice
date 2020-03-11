package arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int a[] = {2,3,4,3,1,3,3};
        System.out.println("Majority Element in the given array : " + majorityElement(a));
    }

    public static int majorityElement(int[] nums) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(count == 0){
                result = nums[ i ];
                count = 1;
            }else if(result == nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return result;
    }
}
