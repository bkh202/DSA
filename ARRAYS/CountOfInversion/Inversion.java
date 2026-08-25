package ARRAYS.CountOfInversion;

import java.util.ArrayList;

public class Inversion {

    // brute force 
    public static int Count(int arr[]) {
        if(arr == null)  return 0;
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; i++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
       // optimal
    public static int merge(int arr[], int left, int mid, int right) {
        int cnt = 0;
        int low = left;
        int high = mid + 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (low <= mid && high <= right) {
            if (arr[low] <= arr[high]) {
                ans.add(arr[low]);
                low++;
            } else {
                ans.add(arr[high]);
                cnt += (mid - low + 1);
                high++;
            }
        }

        while (low <= mid) {
            ans.add(arr[low]);
            low++;
        }
        while (high <= right) {
            ans.add(arr[high]);
            high++;
        }

        for (int i = 0; i < ans.size(); i++) {
            arr[left + i] = ans.get(i);
        }
        return cnt;
    }

    public static int mergeSort(int arr[], int left, int right) {
        int count = 0;
        if (left >= right)
            return count;
        int mid = (left + right) / 2;
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        count += merge(arr, left, mid, right);
        return count;
    }

    public static int inversionCount(int arr[]) {
         if(arr == null)  return 0;
        int n = arr.length;
        int count = mergeSort(arr, 0, n - 1);
        return count;

    }

    public static void main(String[] args) {

    }
}
