package ARRAYS.MajorityElement1;

import java.util.HashMap;
import java.util.Map;

public class Majority {
    public static int majorityElement(int arr[]) {
        if (arr == null || arr.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int mooreVotingAlgo(int arr[]) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        int cnt = 0;
        int ele = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                ele = arr[i];
            } else if (ele == arr[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (ele == arr[i]) {
                cnt1++;
            }
        }
        if (cnt1 > (n / 2))
            return ele;
        return -1;
    }

    public static void main(String[] args) {
       
    }
}
