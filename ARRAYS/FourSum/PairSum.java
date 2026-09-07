package ARRAYS.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {

    // 1. Brute Force
    public static List<List<Integer>> pairSumBrute(int[] arr, int target) {
        if (arr == null || arr.length < 4) {
            return new ArrayList<>();
        }

        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Cast to long to prevent integer overflow on massive inputs
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                        if (sum == target) {
                            List<Integer> ans = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            ans.sort(Integer::compareTo);
                            set.add(ans);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // 2. Better (Hashing)
    public static List<List<Integer>> pairSumBetter(int[] arr, int target) {
        if (arr == null || arr.length < 4) {
            return new ArrayList<>();
        }

        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> st = new HashSet<>(); // Tracks elements seen in the 'k' loop

                for (int k = j + 1; k < n; k++) {
                    long sum = (long) arr[i] + arr[j] + arr[k];
                    long needMore = (long) target - sum;

                    if (st.contains(needMore)) {
                        List<Integer> ans = Arrays.asList(arr[i], arr[j], arr[k], (int) needMore);
                        ans.sort(Integer::compareTo);
                        set.add(ans);
                    }
                    st.add((long) arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    // 3. Optimal (Two-Pointer)
    public static List<List<Integer>> pairSumOptimal(int[] arr, int target) {
        if (arr == null || arr.length < 4) {
            return new ArrayList<>();
        }
        
        
        Arrays.sort(arr);
        
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // Skip duplicates for 'i'
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for 'j'. Ensure j is strictly greater than i + 1
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    
                    if (sum == target) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        
                        // Skip duplicates for 'k' and 'l'
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                        
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, 3, 4, 5, 7, 8 };
        int tar = 23;

        System.out.println("Testing Optimal Approach:");
        List<List<Integer>> ans = pairSumOptimal(arr, tar);

        for (List<Integer> res : ans) {
            System.out.println(res);
        }
    }
}