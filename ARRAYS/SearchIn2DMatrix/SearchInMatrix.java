package ARRAYS.SearchIn2DMatrix;

public class SearchInMatrix {

    // Better Approach: Binary search on specific valid rows
    public static boolean binarySearch(int arr[], int target) {
        if (arr == null || arr.length == 0) return false;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents overflow
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
        if (arr == null || arr.length == 0 || arr[0].length == 0) return false;
        int m = arr[0].length;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Check if target falls within the current row's range
            if (arr[i][0] <= target && arr[i][m - 1] >= target) {
                return binarySearch(arr[i], target);
            }
        }
        return false;
    }

    // Optimal 1: Treat strictly sorted 2D matrix as a flat 1D array
    public static boolean searchInMatrix(int mat[][], int target) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return false;
        
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevents overflow
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

    // Optimal 2: StairCase for row-wise and column-wise sorted matrices
    public static boolean StairCase(int mat[][], int target) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return false;
        
        int row = 0;
        int col = mat[0].length - 1; // Corrected: Start at the last valid index
        
        // Corrected: Run as long as indices remain within matrix bounds
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == target)
                return true;
            else if (mat[row][col] > target)
                col--; // Target is smaller, eliminate current column
            else
                row++; // Target is larger, eliminate current row
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 1, 2, 4, 5 },
                { 6, 7, 8, 9 },
                { 10, 11, 12, 13 }
        };
        // This will now correctly print 'true'
        System.out.println(StairCase(mat, 12));
    }
}