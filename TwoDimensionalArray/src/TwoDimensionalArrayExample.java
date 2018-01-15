import java.util.Arrays;

/**
 * Created by Kisnik on 15.01.2018.
 */



public class TwoDimensionalArrayExample {

    public static void main(String[] args) {

 /*       int[] a = new int[0];

        int[][] matrix = new int[3][];

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i]);
        }

        int[][] matrix2 = new int[3][3];

        printMatrix(matrix2);

        int[] m3[] = {
                {0,1,2},
                {0,1},
                {0}};

        printMatrix(m3);


*/

        int m4[][] = new int[1][3];

        m4[0] = new int[5];
        m4[0][1]=3;
        //m4[1] = new int[6];
        // m4[2] = new int[8];
        printMatrix2(m4);
        printMatrix(m4);
//        printMatrix2(null);
    }

    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void printMatrix2(int[][] m) {
        if (m == null) {  // guard condition
            return;
        }

        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) {
                System.out.println("null");
                continue;
            }
            System.out.print("[");
            for (int j = 0; j < m[i].length; j++) {
                if (j<m[i].length-1){
                    System.out.print(m[i][j]+", ");
                }
                else {
                    System.out.print(m[i][j]);
                }
            }
            System.out.println("]");

        }

    }
    public boolean twoTwo(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==2){
                if(i==(nums.length-1)&&(nums.length>=0)){
                    if(nums[i-1]==2) return true;
                    else return false;
                }
                i++;
                if(i>=nums.length||(nums[i]!=2)) return false;
            }
        }
        return true;

    }


}

