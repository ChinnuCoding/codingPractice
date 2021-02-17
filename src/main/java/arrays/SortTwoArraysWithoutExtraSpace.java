package arrays;

import java.util.Arrays;

/*
*       In-place merge two sorted arrays
 */

class SortTwoArraysWithoutExtraSpace
{
    // Function to in-place merge two sorted arrays X[] and Y[]
    // invariant: `X[]` and `Y[]` are sorted at any point
    public static void merge(int[] X, int[] Y)
    {
        int m = X.length;
        int n = Y.length;

        // Consider each element `X[i]` of array `X` and ignore the element if it is
        // already in the correct order; otherwise, swap it with the next smaller
        // element, which happens to be the first element of `Y`.
        for (int i = 0; i < m; i++)
        {
            // compare the current element of `X[]` with the first element of `Y[]`
            if (X[i] > Y[0])
            {
                // swap `X[i] with `Y[0]`
                int temp = X[i];
                X[i] = Y[0];
                Y[0] = temp;

                int first = Y[0];

                // move `Y[0]` to its correct position to maintain the sorted
                // order of `Y[]`. Note: `Y[1…n-1]` is already sorted
                int k;
                for (k = 1; k < n && Y[k] < first; k++) {
                    Y[k - 1] = Y[k];
                }

                Y[k - 1] = first;
            }
        }
    }

    public static void main (String[] args)
    {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };

        merge(X, Y);

        System.out.println("X: " + Arrays.toString(X));
        System.out.println("Y: " + Arrays.toString(Y));

        differentApproachForInplaceSorting();

        sortArrayInPlace(X, Y);
    }


    public static void differentApproachForInplaceSorting() {
        int a[] = new int[]{1,4,7,8,10};
        int b[] = new int[]{2,3,9};

        int m = a.length;
        int n = b.length;

        for(int j=0;j<m;j++){
            if(a[j] > b[0]){
                int tamp = a[j];
                a[j] = b[0];
                b[0] = tamp;

                Arrays.sort(b);
            }
        }

        for(int i=0;i<m;i++)
            System.out.print(a[i]+" ");
        System.out.print("\n");
        for(int h=0;h<n;h++)
            System.out.print(b[h]+" ");

    }

    public static void sortArrayInPlace(int[] input1, int[] input2) {

        Arrays.sort(input1);

        for(int i = 0; i < input1.length; i++) {
            for(int j = 0; j < input2.length; j++) {
                if (input1[i] < input2[j]) {
                    continue;
                } else {
                    int temp = input1[i];
                    input1[i]=input2[j];
                    input2[j]=temp;
                }
            }
        }

        System.out.println("Array 1");
        for(int i =0 ; i < input1.length; i++) {
            System.out.println(input1[i]);
        }
        Arrays.sort(input2);
        System.out.println("Array 2");
        for(int i = 0; i < input2.length; i++) {
            System.out.println(input2[i]);
        }
    }



}