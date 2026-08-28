package ARRAYS.PowFunction;

public class Pow {
    double power(double b, int e) {
        double ans = 1.0;
        long nn = e;
        if (nn < 0) // converting - to +
            nn = -1 * nn;
        while (nn > 0) {
            if (nn % 2 != 0) {
                ans = ans * b;
                nn = nn - 1;
            } else {
                b = b * b;
                nn = nn / 2;
            }
        }
        if (e < 0)
            ans = (double) 1.0 / (double) ans;
        return ans;
    }

    public static void main(String[] args) {

    }
}
