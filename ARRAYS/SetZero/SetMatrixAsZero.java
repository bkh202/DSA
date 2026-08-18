package ARRAYS.SetZero;

public class SetMatrixAsZero {
    // Brute Force
    public static void setZero(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    for (int col = 0; col < n; col++) {
                        if (mat[col][i] != 0) {
                            mat[col][i] = -1;
                        }
                    }
                    for (int row = 0; row < m; row++) {
                        if (mat[row][j] != 0) {
                            mat[row][j] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }

    }

    // Better

    public static void SetZero2(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        boolean col[] = new boolean[n];
        boolean row[] = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    col[j] = true;
                    row[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (col[j] || row[i]) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    // optimal

    public static void SetZero3(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;

                    if (j != 0) {
                        mat[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
