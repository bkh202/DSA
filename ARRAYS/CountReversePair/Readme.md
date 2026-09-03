# Count Reverse Pairs

**Author:** Md Baktiyar

This repository contains Java implementations to solve the "Reverse Pairs" problem (LeetCode 493). A reverse pair is defined as a pair of indices $(i, j)$ where $i < j$ and $arr[i] > 2 \times arr[j]$.

## 1. Brute Force Approach (`reversePair`)
Evaluates every possible pair in the array to check if it satisfies the reverse pair condition.
*   **Approach:** Uses nested loops. The outer loop selects an element at index $i$, and the inner loop scans all subsequent elements at index $j$. It checks if $arr[i] > 2 \times arr[j]$.
*   **Overflow Prevention:** The multiplication $2 \times arr[j]$ is cast to a 64-bit `long` (`2L * arr[j]`) to prevent integer overflow when dealing with large 32-bit integers.
*   **Time Complexity (TC):** $O(N^2)$ - Compares every pair of elements. Will result in a Time Limit Exceeded (TLE) error for large datasets.
*   **Space Complexity (SC):** $O(1)$ - No extra space allocated.

## 2. Optimal Approach: Merge Sort (`countReversePairs`)
Uses the Divide and Conquer paradigm, modifying the Merge Sort algorithm to count reverse pairs efficiently before merging.
*   **Approach Breakdown:**
    1.  **Divide:** Recursively split the array into two halves until they are individual elements.
    2.  **Count (The Helper):** Before merging two sorted halves (left and right), iterate through the left half. Because both halves are sorted, if `arr[i]` in the left half is greater than `2 * arr[right]`, you can increment the `right` pointer. All remaining elements in the left half will also be greater than `2 * arr[right]`, allowing you to count multiple pairs in $O(N)$ time.
    3.  **Merge:** Standard merge step to combine the two sorted halves back together.
*   **Time Complexity (TC):** $O(N \log N)$ - The array is divided $\log N$ times. The counting and merging steps both take $O(N)$ time at each recursive level.
*   **Space Complexity (SC):** $O(N)$ - Requires an auxiliary buffer to temporarily store the merged elements before writing them back to the original array.