package ARRAYS.MergeIntervals;

import java.util.Arrays;

public class Merge {
    public static int[][] mergeIntervals(int intervals[][]) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        int idx = 0;
        int tem[][] = new int[n][2];
        tem[0][0] = intervals[0][0];
        tem[0][1] = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= tem[idx][1]) {
                tem[idx][1] = Math.max(tem[idx][1], intervals[i][1]);
            } else {
                idx++;
                tem[idx][0] = intervals[i][0];
                tem[idx][1] = intervals[i][1];
            }
        }
        int res[][] = new int[idx + 1][2];
        for (int i = 0; i <= idx; i++) {
            res[i][0] = tem[i][0];
            res[i][1] = tem[i][1];

        }
        return res;
    }

    public static void main(String[] args) {
         int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        int res [][]= mergeIntervals(intervals);
        for(int i=0;i<res.length;i++){
            for(int j=0; j<res[0].length;j++){
                System.out.print(res[i][j] +" ");
            }System.out.println();
        }
    }
}
