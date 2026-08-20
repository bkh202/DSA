package ARRAYS.PascalTringle;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
    // Only Get Single element
    public static int getSingleElement(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Get A Specific Row

    public static void getRow(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * (n - i +1) / i;
            System.out.println(ans);
        }
        
    }

    // Get Entire Pascal Triangle

    public static List<Integer> getTriangleHelper(int row) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int ans = 1;

        for (int col = 1; col < row; col++) {
            ans = ans * (row - col + 1) / col;
            res.add(ans);
        }
        return res;
    }

    public static List<List<Integer>> getTriangle(int n){
        List<List<Integer>> res= new ArrayList<>();

        for(int i=0; i< n;i++){
            res.add(getTriangleHelper(i));
        }
        return res;
    }

    public static void main(String[] args) {

    }

}