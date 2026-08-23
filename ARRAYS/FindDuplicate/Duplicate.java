package ARRAYS.FindDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    // Brute Force
    public static boolean findDuplicateBF(int arr[]) {
        if (arr == null || arr.length <= 1)
            return false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
   // optimal
    public static boolean findDuplicateBetter(int arr[]) {

        if (arr == null || arr.length <= 1)
            return false;

        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    // optimal
    public static boolean findDuplicateOpti(int arr[]) {
        if (arr == null || arr.length <= 1)
            return false;
        int n = arr.length;
        boolean[] nums = new boolean[n + 1];

        for (int ele : arr) {
            if (nums[ele]) {
                return true;
            }
            nums[ele] = true;
        }
        return false;

    }

    public static boolean findDuplicateOptimal(int arr[]) {
        if (arr == null || arr.length <= 1) return false;
        
        Set<Integer> seen = new HashSet<>();
        for (int ele : arr) {
            // HashSet.add() returns false if the element already exists in the set
            if (!seen.add(ele)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5, 4 };
        System.out.println(findDuplicateBF(arr));
    }
}
