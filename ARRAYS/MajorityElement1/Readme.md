# Majority Element (> N/2 Times)

**Author:** Md Baktiyar

This repository contains two Java approaches to solve the "Majority Element" problem. The objective is to find the element that appears more than $N/2$ times in an array of size $N$. 

## 1. Hashing Approach (`majorityElement`)
Uses a HashMap to maintain a frequency count of all elements in the array.
*   **Approach:** Iterates through the array and stores the frequency of each element in a `HashMap`. After populating the map, it iterates through the key-value pairs to find the key whose value (frequency) is strictly greater than $N/2$.
*   **Time Complexity (TC):** $O(N)$ - Requires traversing the array once, and traversing the map once. (Assuming $O(1)$ average insertion time for the HashMap).
*   **Space Complexity (SC):** $O(N)$ - In the worst-case scenario (where all elements are unique), the HashMap will store $N$ distinct key-value pairs.

## 2. Optimal Approach: Moore's Voting Algorithm (`mooreVotingAlgo`)
An ingenious, memory-efficient algorithm that finds the majority element in a single pass without any extra space.
*   **Approach Breakdown:**
    1.  **Phase 1 (Finding a Candidate):** Maintains a `count` and a `candidate` element. It scans the array. If `count` is 0, it picks the current element as the new candidate. If the next element matches the candidate, it increments `count`. If it differs, it decrements `count`. Because a majority element exists more than $N/2$ times, its count will mathematically outlast all other differing elements combined.
    2.  **Phase 2 (Verification):** Since the problem might be fed an array without a valid majority element, a second pass counts the occurrences of the surviving candidate to verify it actually appears more than $N/2$ times.
*   **Time Complexity (TC):** $O(N)$ - Requires exactly two linear passes through the array.
*   **Space Complexity (SC):** $O(1)$ - Only uses two integer variables (`cnt` and `ele`), completely eliminating the $O(N)$ memory overhead of a HashMap.