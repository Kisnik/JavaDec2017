/**
 * Created by Kisnik on 12.02.2018.
 */
public class Snail {
    public void snailArray(int [][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int tmp = 0;
        while (tmp<n && tmp<m){

            for (int i=tmp; i<m-tmp && n-tmp>tmp; i++) { //out of the highest remained line of the array
                System.out.print(arr[tmp][i] + " ");
            }
            for (int i=tmp+1; i<n-tmp; i++) { //out of the rightmost remained line of the array
                System.out.print(arr[i][m - tmp-1] + " ");
            }
            for (int i=m-tmp-2; i>=tmp && n-tmp-1>tmp; i--) { //out of the lowest remained line of the array
                System.out.print(arr[n-tmp-1][i] + " ");
            }
            for (int i=n-tmp-2; i>=tmp+1; i--) { //out of the leftmost remained line of the array
                System.out.print(arr[i][tmp] + " ");
            }
            tmp++;
        }

    }
}
