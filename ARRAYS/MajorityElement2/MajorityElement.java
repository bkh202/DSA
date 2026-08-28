package ARRAYS.MajorityElement2;


import java.util.ArrayList;
import java.util.HashMap;


public class MajorityElement {
    public static ArrayList<Integer> bruteForce(int arr[]) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        cnt++;
                    }
                }
                if (cnt > (n / 3)) {
                    ans.add(arr[i]);
                }
                if (ans.size() == 2) {
                    break;
                }
            }
        }
        return ans;
    }

    public static ArrayList<Integer> Better(int arr[]) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        int n = arr.length;
        int mini = (int) (n / 3) + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val + 1);
            if (map.get(arr[i]) == mini) {
                res.add(arr[i]);
            }
            if (res.size() == 2)
                break;
        }
        return res;
    }

    public static ArrayList<Integer> Optimal(int arr[]) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != arr[i]) {
                cnt1 = 1;
                ele1 = arr[i];
            } else if (cnt2 == 0 && ele1 != arr[i]) {
                cnt2 = 1;
                ele2 = arr[i];
            } else if (ele1 == arr[i])
                cnt1++;
            else if (ele2 == arr[i])
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (ele1 == arr[i])
                cnt1++;
            if (ele2 == arr[i])
                cnt2++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini)
            ans.add(ele1);
        if (cnt2 >= mini)
            ans.add(ele2);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 1, 3, 2, 1, 1 };
        ArrayList<Integer> ans = bruteForce(arr);
        for (int ele : ans) {
            System.out.println(ele);
        }
    }
}
