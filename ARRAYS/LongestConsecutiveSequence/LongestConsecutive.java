package ARRAYS.LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static boolean linearSearch(int arr[], int x) {
        if (arr == null || arr.length == 0)
            return false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return true;
            }
        }
        return false;
    }
     // Brute Using Linear Search
    public static int longestConsecutiveBrute(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int cnt = 1;
            while (linearSearch(arr, x + 1) == true) {
                x = x + 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
      // Better 
    public static int longestConsecutiveBetter(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int cnt = 0;
        int smallest = Integer.MIN_VALUE;
        int longest = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 == smallest) {
                cnt++;
                smallest = arr[i];
            } else if (arr[i] != smallest) {
                cnt = 1;
                smallest = arr[i];
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }
   // Optimal using Hashing
    public static int longestConsecutiveOptimal(int arr[]) {
       
        if (arr == null || arr.length == 0)
            return 0;
         int n = arr.length;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt++;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 1, 9, 4, 5, 3 };
        System.out.println(longestConsecutiveBrute(arr));
    }
}
