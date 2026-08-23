# Find Duplicate in Array

**Author:** Md Baktiyar

This repository contains three different Java approaches to determine if an integer array contains any duplicate elements, demonstrating the progression from brute force to production-ready optimal solutions.

## 1. Brute Force Approach (`findDuplicateBF`)
Checks every element against every other element in the array to find a match.
*   **Approach:** Uses nested loops. The outer loop picks an element, and the inner loop compares it with all subsequent elements. Returns `true` immediately upon finding a match.
*   **Time Complexity (TC):** $O(N^2)$ - Compares every possible pair of elements, resulting in quadratic time complexity.
*   **Space Complexity (SC):** $O(1)$ - No extra space allocated.

## 2. Sorting Approach (`findDuplicateBetter`)
Sorts the array first, which forces any duplicate elements to become adjacent to one another.
*   **Approach:** Sorts the array using Java's built-in `Arrays.sort()`. Iterates through the array with a single loop, comparing each element `arr[i]` with the previous element `arr[i - 1]`.
*   **Time Complexity (TC):** $O(N \log N)$ - The time complexity is dominated by the sorting algorithm. The subsequent linear scan takes $O(N)$ time.
*   **Space Complexity (SC):** $O(1)$ - (Assuming an in-place sorting algorithm is used by the JVM for primitives).
*   **Trade-off:** This modifies (mutates) the original input array, which may not be acceptable in all system architectures.

## 3. True Optimal Approach (`findDuplicateOptimal`)
The industry standard for solving this problem safely for all integer ranges (positive, negative, and zero) without modifying the original array.
*   **Approach:** Initializes a `HashSet`. Iterates through the array, attempting to add each element to the set. Because a `HashSet` cannot contain duplicates, the `.add()` method will return `false` if the element has already been seen, allowing us to immediately return `true`.
*   **Time Complexity (TC):** $O(N)$ - Single pass through the input array. `HashSet` insertions take $O(1)$ time on average.
*   **Space Complexity (SC):** $O(N)$ - In the worst-case scenario (no duplicates), all $N$ elements are stored in the `HashSet`.

## 3. Frequency Array Approach (`findDuplicateOpti`)
Uses a boolean frequency array to track seen elements. 
*   **⚠️ CRITICAL CONSTRAINT:** This specific approach is only valid if all array elements are positive integers strictly within the range of $0$ to $N$ (where $N$ is the length of the array). **It will throw an `ArrayIndexOutOfBoundsException` if the array contains negative numbers or values greater than the array's length.** (For a generally optimal solution that handles all integers, a `HashSet` is required).
*   **Approach:** Initializes a boolean array `nums` of size $N + 1$. Iterates through the input array. If `nums[ele]` is true, the element is a duplicate. Otherwise, marks `nums[ele]` as true.
*   **Time Complexity (TC):** $O(N)$ - Single pass through the input array.
*   **Space Complexity (SC):** $O(N)$ - Requires allocating an auxiliary boolean array of size $N + 1$.