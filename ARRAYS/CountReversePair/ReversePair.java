package ARRAYS.CountReversePair;

import java.util.ArrayList;

public class ReversePair {
    // brute force
    public static int reversePair(int arr[]) {
        if (arr == null || arr.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (long) 2L * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    // optimal 
    public static int countReversePairs(int arr[]) {
          if(arr==null || arr.length ==0) return 0;
         return mergeSort(arr, 0, arr.length-1);
    }

    public static int countReversePairHelper(int arr[], int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (long) 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low >= high)
            return count;

        int mid = low+(high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += countReversePairHelper(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> ans = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                ans.add(arr[left]);
                left++;
            } else {
                ans.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            ans.add(arr[left]);
            left++;
        }
        while (right <= high) {
            ans.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = ans.get(i - low);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 5, 1, 20 };
        System.out.println(countReversePairs(arr));
    }
}
