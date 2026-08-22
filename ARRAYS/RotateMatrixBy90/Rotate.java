package ARRAYS.RotateMatrixBy90;

public class Rotate {
    // Brute Force
    public static int[][] rotateMatrixBy90Clockwise(int mat[][]) {

        int n = mat.length;
        int tem[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tem[j][n - 1 - i] = mat[i][j];
            }
        }
        return tem;
    }
    // Optimal using transpose and reverse every row one by one

    public static void rotateMatrixBy90ClockWise(int mat[][]) {
        if (mat == null || mat.length == 0)
            return;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tem = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tem;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // this also the optimal
    public static void rotateMatrixAntiClock(int[][] mat) {
        if (mat == null || mat.length == 0)
            return;
        // code here
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int j = 0; j < n; j++) {
            int top = 0;
            int bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }

    public static void main(String[] args) {

    }
}
