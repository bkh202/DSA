**# Sort 0s, 1s and 2s**

**## Problem Statement**

Given an array containing only `0`, `1`, and `2`, sort the array in ascending order without using a built-in sorting algorithm.

Example:

```text
Input:
2 0 1 2 1 0

Output:
0 0 1 1 2 2

# Approaches

There are two approaches implemented in this code:

Brute Force Approach
Optimal Approach — Dutch National Flag Algorithm

# Approach 1: Brute Force

## Idea

Count the number of 0s, 1s, and 2s in the array.

Then overwrite the array:

First place all 0s.
Then place all 1s.
Finally place all 2s.

This avoids comparison-based sorting.

## Steps

Traverse the array and count 0s, 1s, and 2s.
Fill the first count0 positions with 0.
Fill the next count1 positions with 1.
Fill the remaining positions with 2.

## Time Complexity

O(N)

## Space Complexity

O(1)
Approach 2: Optimal — Dutch National Flag Algorithm

## Idea

Use three pointers to divide the array into three regions:

0s | 1s | Unprocessed | 2s

The pointers represent:

nextZero → position where the next 0 should be placed.
i → current element being processed.
nextTwo → position where the next 2 should be placed.

## Algorithm

For each element:

If the element is 0, swap it with the nextZero position and move both pointers.
If the element is 1, move the current pointer.
If the element is 2, swap it with the nextTwo position and move nextTwo.

The 2 case does not increment i because the swapped element has not been processed yet.

## Time Complexity

O(N)

## Space Complexity

O(1)

# Complexity Comparison

Approach	Time Complexity	Space Complexity
Brute Force	O(N)	O(1)
Dutch National Flag	O(N)	O(1)

# Important Note

The optimal method should process elements while:

i <= nextTwo

The current implementation uses:

i <= nextZero

which is incorrect for the Dutch National Flag algorithm.

The loop condition should be changed to:

i <= nextTwo

# Key Takeaways

The Brute Force approach counts the occurrences of 0, 1, and 2 and rewrites the array.
The Dutch National Flag Algorithm sorts the array in a single traversal.
Both approaches use O(1) extra space.
The optimal approach uses three pointers and performs the sorting in O(N) time.
When swapping a 2 to the end, the current index should not be incremented because the newly swapped element still needs to be processed.

# File

Sort012.java

# Author

Md Bakhtiyar