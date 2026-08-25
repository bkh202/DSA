package ARRAYS.SearchIn2DMatrix;

public class SearchInMatrix {

    // better Apparach
    public static boolean binarySearch(int arr[], int target) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean Search(int arr[][], int target) {
        int m = arr[0].length;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] <= target && arr[i][m - 1] >= target) {
                return binarySearch(arr[i], target);
            }
        }
        return false;
    }

    // Optimal using Flat 2D in 1D array
    public static boolean searchInMatrix(int mat[][], int target) {
        if (mat == null)
            return false;
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    // using Stair Case Optimal

    public static boolean StairCase(int mat[][], int target) {
        if (mat == null)
            return false;
        int row = 0;
        int col = mat[0].length;
        while (row < mat.length && col >= 0) {
            if (target == mat[row][col] )
                return true;
            else if (mat[row][col] > target)
                col--;
            else
                row++;

        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, 4, 5 },
                { 6, 7, 8, 9 },
                { 10, 11, 12, 13 }
        };
        System.out.println(StairCase(mat, 12));
    }
}
