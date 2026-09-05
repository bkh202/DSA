# 3Sum Problem

**Author:** Md Baktiyar

This repository contains three robust Java approaches to solve the classic "3Sum" problem (LeetCode 15). The objective is to find all unique triplets in an integer array that sum to exactly `0`.

## 1. Brute Force Approach (`pairSumBrute`)
Checks every possible triplet combination in the array.
*   **Approach:** Uses three nested loops to evaluate every triplet. If the sum is `0`, it sorts the three numbers and adds them to a `HashSet` to ensure only unique triplets are kept.
*   **Time Complexity (TC):** `O(N^3 * log(M))` - Three nested loops dictate `O(N^3)`. Sorting the triplet of size 3 is `O(1)`, but inserting into a HashSet takes logarithmic time based on the current set size (`M`). 
*   **Space Complexity (SC):** `O(M)` - Space is required to store the valid unique triplets in the HashSet.

## 2. Hashing Approach (`pairSumBetter`)
Reduces the third loop to an `O(1)` lookup using a HashSet.
*   **Approach:** Uses two nested loops to fix the first two numbers (`arr[i]` and `arr[j]`). It computes the required third number (`-(arr[i] + arr[j])`) and checks if it exists in a secondary `HashSet` that tracks elements seen so far in the inner loop. Valid triplets are sorted and stored in the primary `HashSet` to filter out duplicates.
*   **Time Complexity (TC):** `O(N^2 * log(M))` - The two loops take `O(N^2)`, and HashSet insertion adds a logarithmic factor for uniqueness.
*   **Space Complexity (SC):** `O(N) + O(M)` - Requires a temporary HashSet to store up to `N` elements during iteration, plus the final set of `M` unique triplets.

## 3. Optimal Two-Pointer Approach (`pairSumOptimal`)
Sorts the array and uses a two-pointer technique to find valid triplets without needing auxiliary hash sets to filter duplicates.
*   **⚠️ DANGER - MUTATES INPUT:** This method calls `Arrays.sort(arr)` directly on the input array, permanently altering its order in memory.
*   **Approach:** Sorts the array first. Iterates through the array with a fixed pointer `i`. For each `i`, sets a `left` pointer at `i + 1` and a `right` pointer at the end of the array. It converges the pointers based on whether the sum is greater than or less than `0`. It handles duplicates efficiently by skipping identical adjacent elements.
*   **Time Complexity (TC):** `O(N log N + N^2)` which simplifies to `O(N^2)` - Sorting takes `O(N log N)`. The outer loop runs `N` times, and the inner two-pointer scan takes `O(N)` time.
*   **Space Complexity (SC):** `O(1)` - (Excluding the space used to return the final list and assuming an in-place sort). Uses no extra hash tables or buffers.