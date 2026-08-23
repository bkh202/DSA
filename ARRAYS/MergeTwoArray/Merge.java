package ARRAYS.MergeTwoArray;

import java.util.Arrays;

public class Merge {
    // for unsorted Arrays
    public static int[] mergeArray(int a[], int n, int b[], int m) {
        if (a == null && b == null)
            return new int[0];
        if (a == null)
            return b.clone();
        if (b == null)
            return a.clone();
        int ans[] = new int[n + m];
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                ans[k++] = a[i++];
            } else {
                ans[k++] = b[j++];
            }
        }
        while (i < n) {
            ans[k++] = a[i++];
        }
        while (j < m) {
            ans[k++] = b[j++];
        }
        return ans;
    }

    // opimal for sorted array

    public static void mergeArraysOptimal(int arr1[], int arr2[]) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 1)
            return;
        int left = arr1.length - 1;
        int right = 0;
        while (left >= 0 && right < arr2.length) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    public static void mergeArrays3(int a[], int b[], int n, int m) {
        if (a == null || b == null)
            return;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }
    }

    public static void main(String[] args) {
        int a[] = { 5, 3, 8, 1 };
        int b[] = { 6, 2, 3, 4, 10 };

    }
}
