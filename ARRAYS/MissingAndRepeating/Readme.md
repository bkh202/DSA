# Find Missing and Repeating Number

**Author:** Md Baktiyar

This repository contains three Java approaches to solve the "Missing and Repeating Number" problem. Given an unsorted array of size $N$ containing elements from $1$ to $N$, one number is missing and one number occurs twice. The algorithms identify both.

## 1. Brute Force Approach (`Sol`)
Iterates through every possible number from $1$ to $N$ and counts its occurrences in the input array.
*   **Approach:** Uses nested loops. The outer loop picks an integer $i$ from $1$ to $N$. The inner loop traverses the array to count how many times $i$ appears. A count of $2$ identifies the repeating number; a count of $0$ identifies the missing number.
*   **Time Complexity (TC):** $O(N^2)$ - For each of the $N$ numbers, it scans the entire array of size $N$.
*   **Space Complexity (SC):** $O(1)$ - No extra space allocated.

## 2. Frequency Array Approach (`misAndRepeat`)
Uses an auxiliary hash array to keep track of element frequencies in a single pass.
*   **Approach:** Initializes an integer array `hash` of size $N + 1$. Iterates through the input array and increments the count at `hash[arr[i]]`. A second pass through the `hash` array identifies the index with a value of $2$ (repeating) and $0$ (missing).
*   **Time Complexity (TC):** $O(N)$ - Two separate linear passes (one over the input array, one over the hash array).
*   **Space Complexity (SC):** $O(N)$ - Requires an auxiliary array of size $N + 1$.

## 3. Optimal Mathematical Approach (`findTwoElement`)
Solves the problem mathematically using the sum of first $N$ natural numbers and the sum of their squares, completely avoiding extra memory allocation.
*   **Approach:** 
    1. Calculates the expected sum ($S$) and expected sum of squares ($S2$) for numbers $1$ to $N$.
    2. Calculates the actual sum ($SN$) and actual sum of squares ($S2N$) from the given array.
    3. Uses the formulas $X - Y = SN - S$ and $X^2 - Y^2 = S2N - S2$ (where $X$ is the repeating number and $Y$ is the missing number).
    4. Solves the linear equations to extract $X$ and $Y$. 
    *(Note: 64-bit `long` integers are strictly used to prevent integer overflow during square calculations).*
*   **Time Complexity (TC):** $O(N)$ - A single linear pass through the input array.
*   **Space Complexity (SC):** $O(1)$ - Only uses a few variables for mathematical tracking.