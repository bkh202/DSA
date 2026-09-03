package ARRAYS.GridPath;

public class FindPath {
      public static int findPathHelper(int mat[][], int i, int j , int n , int m){
           if(i == (n-1) && j ==(m-1)) return 1;
            if(i >= n || j >=m) return 0;

            return findPathHelper(mat, i+1, j, n, m)+findPathHelper(mat, i, j+1, n, m);
      }
      public static int findPath(int mat[][]){
          int n=mat.length;
          int m=mat[0].length;
          return findPathHelper(mat, 0, 0, n, m);
      }
    public static void main(String[] args) {
        int grid[][] = {{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.println(findPath(grid));
    }
}
