import java.util.Scanner;

/**
 * Created by Kisnik on 12.02.2018.
 */
public class SnailTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n = in.nextInt();
        System.out.println("Enter the number of columns");
        int m = in.nextInt();
        if (n == 0 || m == 0) { //check of  array dimension
            System.out.println("Error, wrong value");
            return;
        }
        int arr[][] = new int[n][m]; //enter an array
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the row number " + (i + 1) + ": ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Snail testArray = new Snail();
        testArray.snailArray(arr); //out af the array by snail
    }
}
