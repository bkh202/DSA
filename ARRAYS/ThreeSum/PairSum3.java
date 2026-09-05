package ARRAYS.ThreeSum;

import java.util.*;

public class PairSum3 {

    public static List<List<Integer>> pairSumBrute(int arr[], int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Long> st = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    if (sum == target) {
                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(arr[i]);
                        res.add(arr[j]);
                        res.add(arr[k]);
                        res.sort(Integer::compareTo);
                        set.add(res);
                    }
                    st.add((long) arr[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;

    }

    public static List<List<Integer>> pairSumBetter(int arr[]) {
        Set<List<Integer>> set = new HashSet<>();

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            Set<Long> st = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i];
                sum += arr[j];
                int needmore = 0 - sum;
                if (st.contains((long) needmore)) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(arr[i]);
                    ans.add(arr[j]);
                    ans.add((int) needmore);
                    ans.sort(Integer::compareTo);
                    set.add(ans);
                }
                st.add((long) arr[j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ans = pairSumBetter(arr);
        for (List<Integer> ele : ans) {
            for (int res : ele) {
                System.out.print(res + " ");
            }
        }
    }
}
