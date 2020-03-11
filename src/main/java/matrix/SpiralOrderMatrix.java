package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int x=0;
        int y=0;

        while(m>0 && n>0){

            //if one row/column left, no circle can be formed
            if(m==1){
                for(int i=0; i<n; i++){
                    result.add(matrix[x][y++]);
                }
                break;
            }else if(n==1){
                for(int i=0; i<m; i++){
                    result.add(matrix[x++][y]);
                }
                break;
            }

            //below, process a circle

            //top - move right
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y++]);
            }

            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }

            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }

            //left - move up
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;
        }

        return result;
    }

    public List<Integer> spiralOrderDiffApproach(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return result;

        int m = matrix.length;
        int n = matrix[0].length;

        int left=0;
        int right=n-1;
        int top = 0;
        int bottom = m-1;

        while(result.size()<m*n){
            for(int j=left; j<=right; j++){
                result.add(matrix[top][j]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            //prevent duplicate row
            if(bottom<top)
                break;

            for(int j=right; j>=left; j--){
                result.add(matrix[bottom][j]);
            }
            bottom--;

            // prevent duplicate column
            if(right<left)
                break;

            for(int i=bottom; i>=top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}