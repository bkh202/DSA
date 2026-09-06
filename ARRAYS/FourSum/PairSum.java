package ARRAYS.FourSum;

import java.util.*;

public class PairSum {
    public static List<List<Integer>> pairSumBrute(int arr[], int target) {
        if (arr == null || arr.length < 4)
            return new ArrayList<>();
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> st = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        List<Integer> ans = new ArrayList<>();
                        int sum = arr[i];
                        sum += arr[j];
                        sum += arr[k];
                        sum += arr[l];
                        if (sum == target) {
                            ans.add(arr[i]);
                            ans.add(arr[j]);
                            ans.add(arr[k]);
                            ans.add(arr[l]);
                            ans.sort(Integer::compareTo);
                            set.add(ans);
                        }
                        st.add((long) arr[l]);
                    }

                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    public static List<List<Integer>> pairSumBetter(int arr[], int target) {
        if (arr == null || arr.length < 4)
            return new ArrayList<>();
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> st = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    int needmore = target - sum;
                    if (st.contains((long) needmore)) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[k]);
                        ans.add((int) needmore);
                        ans.sort(Integer::compareTo);
                        set.add(ans);
                    }
                    st.add((long) arr[k]);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 3, 4, 5, 7, 8 };
        int tar = 23;
        List<List<Integer>> ans =pairSumBrute(arr, tar);

        for (List<Integer> res : ans) {
            for (int ele : res) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
