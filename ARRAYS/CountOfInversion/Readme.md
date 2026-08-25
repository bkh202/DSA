# Count Inversions in an Array

**Author:** Md Baktiyar

This repository contains Java implementations to solve the "Count Inversions" problem. Two elements `a[i]` and `a[j]` form an inversion if `a[i] > a[j]` and `i < j`.

## 1. Brute Force Approach (`Count`)
Checks every possible pair in the array to see if it forms an inversion.
*   **Approach:** Uses nested loops. The outer loop picks an element at index `i`, and the inner loop checks all subsequent elements at index `j`. If `arr[i] > arr[j]`, the inversion count is incremented.
*   **Time Complexity (TC):** $O(N^2)$ - Compares every pair of elements. Unsuitable for large datasets.
*   **Space Complexity (SC):** $O(1)$ - No extra space allocated.

## 2. Optimal Approach: Merge Sort (`inversionCount`)
Utilizes the Divide and Conquer paradigm by modifying the standard Merge Sort algorithm to count inversions efficiently.
*   **Approach:** 
    1. Recursively divide the array into two halves until each half contains a single element.
    2. During the `merge` step, compare elements from the left subarray and the right subarray.
    3. Since both subarrays are sorted, if an element in the left subarray (`arr[low]`) is strictly greater than an element in the right subarray (`arr[high]`), it means `arr[low]` is also greater than all remaining elements in the left subarray. 
    4. The number of inversions added in this step is exactly `(mid - low + 1)`.
*   **Time Complexity (TC):** $O(N \log N)$ - The array is divided $\log N$ times, and the merge step takes $O(N)$ time at each level of the recursion tree.
*   **Space Complexity (SC):** $O(N)$ - Requires an auxiliary array/list to temporarily store the merged elements before copying them back to the original array.