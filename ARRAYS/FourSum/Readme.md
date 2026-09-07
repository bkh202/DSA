# 4Sum Problem

**Author:** Md Baktiyar

This repository contains three Java implementations for solving the "4Sum" problem (LeetCode 18). The objective is to find all unique quadruplets in an array that sum to a specific `target` value.

## 1. Brute Force Approach (`pairSumBrute`)
Evaluates every possible combination of four elements.
*   **Approach:** Uses four nested loops to check all possible quadruplets. If a quadruplet matches the target, it is sorted and stored in a `HashSet` to guarantee uniqueness.
*   **Time Complexity (TC):** O(N^4 * log M) - The four nested loops dictate O(N^4). Sorting the 4 elements is O(1), but inserting into the HashSet adds a logarithmic factor based on the number of unique quadruplets (M).
*   **Space Complexity (SC):** O(M) - Space required to store the unique quadruplets in the HashSet.

## 2. Hashing Approach (`pairSumBetter`)
Reduces the fourth loop to an O(1) mathematical lookup using a HashSet.
*   **Approach:** Uses three nested loops to fix the first three elements. Calculates the required fourth element (`target - sum`). It checks a secondary HashSet (which tracks elements seen in the innermost loop) to see if the required element exists. Valid quadruplets are sorted and added to a primary HashSet to eliminate duplicates.
*   **Time Complexity (TC):** O(N^3 * log M) - The three loops take O(N^3), with HashSet insertions adding a logarithmic factor for uniqueness.
*   **Space Complexity (SC):** O(N) + O(M) - Requires a temporary HashSet to store up to N elements during the innermost iteration, plus the space for the final set of unique quadruplets.

## 3. Optimal Two-Pointer Approach (`pairSumOptimal`)
Sorts the array and uses a converging two-pointer technique to find valid quadruplets, eliminating the need for extra hash tables.
*   **⚠️ DANGER - MUTATES INPUT:** This method calls `Arrays.sort(arr)` directly on the input array, permanently altering its sequence in memory.
*   **Approach:** Sorts the array. Uses two nested loops to fix the first two pointers (`i` and `j`). Sets a `left` pointer at `j + 1` and a `right` pointer at the end of the array. It converges the pointers based on whether the total sum is greater than or less than the target. It intelligently skips identical adjacent elements to prevent duplicate quadruplets.
*   **Overflow Protection:** Accumulates the sum using a 64-bit `long` to prevent integer overflow when adding four potentially massive 32-bit integers.
*   **Time Complexity (TC):** O(N^3) - Sorting takes O(N log N). The two outer loops run O(N^2) times, and the inner two-pointer scan takes O(N) time, resulting in O(N^3) overall.
*   **Space Complexity (SC):** O(1) - (Assuming an in-place sort and excluding the memory used to return the final list). No auxiliary data structures are used.