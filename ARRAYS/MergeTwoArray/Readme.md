# Merge Arrays

**Author:** Md Baktiyar

This repository contains three different Java algorithms for merging arrays, covering unsorted merging, in-place optimal sorting, and buffer merging.

## 1. Merge Unsorted Arrays (`mergeArray`)
Merges two unsorted arrays into a single sorted array.
*   **⚠️ DANGER - MUTATES INPUT:** This method calls `Arrays.sort()` directly on the input arrays `a` and `b` before merging. **Do not use this method** if the original order of the source arrays must be preserved elsewhere in your application.
*   **Approach:** Sorts both input arrays, then uses a two-pointer approach to compare elements and build a new sorted combined array.
*   **Time Complexity (TC):** $O(N \log N + M \log M + N + M)$ - Dominated by the initial sorting of the two arrays.
*   **Space Complexity (SC):** $O(N + M)$ - Allocates a new array of size $N + M$ to hold the result.

## 2. Merge Two Sorted Arrays In-Place (`mergeArraysOptimal`)
Merges two pre-sorted arrays without using an extra $O(N+M)$ buffer array.
*   **Approach:** Uses two pointers. `left` starts at the end of `arr1`, and `right` starts at the beginning of `arr2`. It swaps elements so that all the smaller elements end up in `arr1` and all the larger elements in `arr2`. Finally, it re-sorts both arrays to restore their internal order.
*   **Time Complexity (TC):** $O(\min(N, M) + N \log N + M \log M)$ - Swapping takes linear time based on the smaller array, followed by sorting both arrays.
*   **Space Complexity (SC):** $O(1)$ - The transformation is done strictly in-place.

## 3. Merge Sorted Arrays into Buffer (`mergeArrays3`)
Merges two pre-sorted arrays where the first array has enough empty buffer space at the end to hold the second array (LeetCode 88 style).
*   **Approach:** Iterates backward. Compares the largest elements of both arrays and places the greater element at the very end of the buffered array. This prevents overwriting valid elements in the first array before they are evaluated.
*   **Time Complexity (TC):** $O(N + M)$ - Single backward pass through both arrays.
*   **Space Complexity (SC):** $O(1)$ - Done in-place utilizing the existing buffer space.