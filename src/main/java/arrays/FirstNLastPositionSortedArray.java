package arrays;

import java.util.List;

public class FirstNLastPositionSortedArray {

    public static void main(String[] args) {
        int a[] = {1,2,3,3,4,5,6,6,6,7,8};
        int[] returnRange = new int[2];
        returnRange = searchRange(a,6);

        System.out.println("Range : " + returnRange[0]+ " - " + returnRange[1]);
    }

    static int[] searchRange(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;

        while(l<r){
            int m=l+(r-l)/2;
            if(nums[m]<target){
                l=m+1;
            }else{
                r=m;
            }
        }

        int first=l;
        if(l<nums.length&&nums[l]==target){//l is in boundary and is the target
            l=0;
            r=nums.length-1;
            while(l<r){
                int m=l+(r-l+1)/2;
                if(nums[m]>target){
                    r=m-1;
                }else{
                    l=m;
                }
            }

            return new int[]{first, r};
        }

        return new int[]{-1,-1};
    }
}
