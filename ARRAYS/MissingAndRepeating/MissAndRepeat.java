package ARRAYS.MissingAndRepeating;

import java.util.ArrayList;

public class MissAndRepeat {
    // brute force
    public static int[] Sol(int arr[]) {
        int missing = -1;
        int repeating = -1;

        for (int i = 1; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i)
                    count++;
            }
            if (count == 2)
                repeating = i;
            if (count == 0)
                missing = i;
            if (missing != -1 && repeating != -1)
                break;
        }
        return new int[] { missing, repeating };
    }
    // better
    public static int[] misAndRepeat(int arr[]) {
        int missing = -1;
        int repeating = -1;
        int hash[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                repeating = i;
            }
            if (hash[i] == 0) {
                missing = i;
            }
            if (missing != -1 && repeating != -1) {
                break;
            }
        }
        return new int[] { missing, repeating };
    }
    // Optimal
    	ArrayList<Integer> findTwoElement(int arr[]) {
		long n = arr.length;
		ArrayList<Integer> list = new ArrayList<>();
		// code here
		long S = (n*(n + 1))/2;
		long S2 = (n*(n + 1)*(2*n + 1))/6;
		long SN = 0;
		long S2N = 0;
		for (int i = 0; i<n; i++) {
			SN += (long)arr[i];
			S2N += (long)arr[i]*(long)arr[i];
		}
		long val1 = SN - S;   // Represents X - Y
        long val2 = S2N - S2; // Represents X^2 - Y^2
		val2 = val2/val1;
		long x = (val1 + val2)/2;
		long y = x - val1;
		list.add((int)x);
		list.add((int)y);
		return list;
		
	}

    public static void main(String[] args) {

    }
}
