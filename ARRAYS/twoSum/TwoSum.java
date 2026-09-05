package ARRAYS.twoSum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // brute force
    public static int[] pairSum(int arr[], int target) {
        if (arr == null || arr.length == 0)
            return new int[] { -1, -1 };
        int ans[] = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return  new int []{-1,-1};
    }

    // Better
    public static boolean pairSumBetter(int arr[], int target) {
        if (arr == null || arr.length == 0)
            return false;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int needmore = target - num;
            if (mp.containsKey(needmore)) {
                return true;
            }
            mp.put(arr[i], i);
        }
        return false;
    }

    // optimal
    public static boolean pairSumOptimal(int arr[], int target) {
        if (arr == null || arr.length == 0)
            return false;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 9, 10, 4, 15 };
        int ans[] = pairSum(arr, 1);
        for (int ele : ans) {
            System.out.println(ele);
        }
        System.out.println(pairSumBetter(arr, 1));
    }
}
