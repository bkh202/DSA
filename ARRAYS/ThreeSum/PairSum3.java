package ARRAYS.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum3 {

    // Brute Force
    public static List<List<Integer>> pairSumBrute(int arr[]) {
       
        if (arr == null || arr.length < 3) {
            return new ArrayList<>();
        }
        
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        
                        List<Integer> res = Arrays.asList(arr[i], arr[j], arr[k]);
                        res.sort(Integer::compareTo);
                        set.add(res);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // Better
    public static List<List<Integer>> pairSumBetter(int arr[]) {
        if (arr == null || arr.length < 3) {
            return new ArrayList<>();
        }
        
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                int needMore = -sum; 
                
                if (st.contains(needMore)) {
                    List<Integer> ans = Arrays.asList(arr[i], arr[j], needMore);
                    ans.sort(Integer::compareTo);
                    set.add(ans);
                }
                
                st.add(arr[j]); 
            }
        }
        return new ArrayList<>(set);
    }

    // Optimal
    public static List<List<Integer>> pairSumOptimal(int[] arr) {
        if (arr == null || arr.length < 3) {
            return new ArrayList<>();
        }
        
       
        Arrays.sort(arr);
        
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // Skip duplicates for the fixed 'i' pointer
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    
                    // Skip duplicates for the 'j' and 'k' pointers
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                    
                } else if (sum < 0) {
                    j++; // Sum is too small, move left pointer up
                } else {
                    k--; // Sum is too large, move right pointer down
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = pairSumOptimal(arr); // Testing the optimal method
        
        for (List<Integer> triplet : ans) {
            System.out.println(triplet);
        }
    }
}