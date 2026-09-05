# Two Sum Problem

**Author:** Md Baktiyar

This repository contains three Java approaches to the classic "Two Sum" problem. It demonstrates the progression from checking all pairs to using HashMaps and Two-Pointer techniques.

*Note: The methods in this class currently solve two different variations of the problem (returning indices vs. returning existence).*

## 1. Brute Force (`pairSum`)
Checks every possible pair to see if their sum matches the target.
*   **Returns:** An `int[]` containing the original indices of the two numbers.
*   **Approach:** Uses nested loops. For every element at index $i$, it checks all subsequent elements at index $j$ to see if $arr[i] + arr[j] == target$.
*   **Time Complexity (TC):** $O(N^2)$ - Evaluates every pair in the array.
*   **Space Complexity (SC):** $O(1)$ - Allocates a static array of size 2.

## 2. Hashing Approach (`pairSumBetter`)
Uses a HashMap to track the required complementary number in a single pass.
*   **Returns:** A `boolean` indicating if a valid pair exists.
*   **Approach:** Iterates through the array. For each element, it calculates the complement (`target - current`). If the complement already exists in the HashMap, a valid pair has been found. If not, the current element is added to the HashMap.
*   **Time Complexity (TC):** $O(N)$ - A single pass through the array. HashMap lookups take $O(1)$ time on average.
*   **Space Complexity (SC):** $O(N)$ - Requires storing up to $N$ elements in the HashMap.

## 3. Optimal Two-Pointer Approach (`pairSumOptimal`)
Sorts the array and uses a converging two-pointer technique to find the target sum.
*   **⚠️ DANGER - MUTATES INPUT:** This method calls `Arrays.sort(arr)` directly on the input parameter. This permanently alters the order of the original data in memory. Do not use this method if the original array order must be preserved.
*   **Returns:** A `boolean` indicating if a valid pair exists. *(Note: This approach cannot easily return the original indices because the array has been sorted, destroying the original index mappings).*
*   **Approach:** Sorts the array. Places a `left` pointer at the start and a `right` pointer at the end. If the sum is too small, move `left` up to increase the sum. If the sum is too large, move `right` down to decrease the sum.
*   **Time Complexity (TC):** $O(N \log N)$ - Dominated by the sorting algorithm. The two-pointer scan takes $O(N)$.
*   **Space Complexity (SC):** $O(1)$ - (Assuming an in-place sort). Uses no extra structural memory.