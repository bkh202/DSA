**# Maximum Subarray Sum — Kadane's Algorithm**


**## Problem Statement**


Given an integer array, find the contiguous subarray with the maximum sum and return its sum.


---


**# Approaches**


There are three approaches implemented in this code:


1. **Brute Force Approach**
2. **Better Approach**
3. **Optimal Approach — Kadane's Algorithm**


---


**# Approach 1: Brute Force**


**## Idea**


Generate every possible subarray and calculate its sum.


The approach uses three loops:


- The first loop selects the starting index.
- The second loop selects the ending index.
- The third loop calculates the sum of the selected subarray.


The maximum sum found is returned.


---


**## Time Complexity**


```text
O(N³)

## Space Complexity

O(1)

# Approach 2: Better

## Idea

Avoid the third loop used in the brute-force approach.

For every starting index, maintain a running sum while expanding the subarray.

sum += arr[j]

After adding each element, update the maximum sum.

This reduces the time complexity by calculating the subarray sum incrementally.

## Time Complexity

O(N²)

## Space Complexity

O(1)

# Approach 3: Optimal — Kadane's Algorithm

## Idea

Kadane's Algorithm maintains a running subarray sum.

For every element, decide whether to:

Continue the existing subarray.
Start a new subarray from the current element.

The current sum is updated using:

max(current element, current sum + current element)

The maximum value encountered during the traversal is the maximum subarray sum.

## Time Complexity

O(N)

## Space Complexity

O(1)

# Complexity Comparison

Approach	Time Complexity	Space Complexity
Brute Force	O(N³)	O(1)
Better	O(N²)	O(1)
Kadane's Algorithm	O(N)	O(1)

# Key Takeaways

The Brute Force approach checks every possible subarray and takes O(N³) time.
The Better approach maintains a running sum and reduces the time to O(N²).
Kadane's Algorithm optimizes the problem to O(N) time.
All three approaches use O(1) extra space.
Kadane's Algorithm is the preferred approach for solving the maximum subarray sum problem.

# File

KadaneAlgo.java

# Author

Md Bakhtiyar