# Search in a 2D Matrix

**Author:** Md Baktiyar

This repository contains robust, production-ready Java implementations for searching for a target integer in a 2D matrix. It covers three distinct algorithmic approaches, each optimized for different matrix sorting conditions.

## Algorithm Comparison

| Approach | Time Complexity | Space Complexity | Required Matrix State |
|---|---|---|---|
| **Row-wise Binary Search** | $O(N + \log M)$ | $O(1)$ | Each row is sorted independently |
| **1D Flattened Search** | $O(\log(N \times M))$ | $O(1)$ | Strictly sorted (last element of row $i$ < first element of row $i+1$) |
| **Staircase Search** | $O(N + M)$ | $O(1)$ | Sorted both row-wise (left to right) AND column-wise (top to bottom) |

---

## 1. Row-wise Binary Search (`Search`)
A hybrid approach that skips invalid rows and performs a binary search only on the row that could potentially contain the target.
*   **Approach:** Iterates through each row. Checks if the `target` falls between the first and last elements of that row. If it does, it executes a standard binary search on that specific row.
*   **Best Use Case:** When the rows are sorted, but there is no guaranteed relationship between the end of one row and the beginning of the next.

## 2. 1D Flattened Binary Search (`searchInMatrix`)
The true optimal solution for a strictly sorted matrix. It mathematically maps 2D coordinates to a 1D sequence to achieve logarithmic time across the entire dataset.
*   **Approach:** Treats the $N \times M$ matrix as a single flattened 1D array of length $N \times M$. Uses the `/` and `%` operators to map the 1D `mid` index back to a 2D `row` and `col`. 
*   **Coordinate Mapping:** 
    *   `row = mid / M`
    *   `col = mid % M`
*   **Best Use Case:** Matrices where the entire dataset is one continuous sorted sequence (e.g., LeetCode 74).

## 3. Staircase Search (`StairCase`)
An optimal $O(N + M)$ algorithm for matrices where elements increase sequentially both downwards and to the right.
*   **Approach:** Begins at the top-right corner (first row, last column). 
    *   If the target is smaller than the current element, move **left** (eliminate the column).
    *   If the target is larger than the current element, move **down** (eliminate the row).
*   **Best Use Case:** Matrices that are sorted row-wise and column-wise, but *not* strictly sorted sequentially (e.g., LeetCode 240).