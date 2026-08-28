# Majority Element II (> N/3 Times)

**Author:** Md Baktiyar

This repository contains three Java approaches to solve the "Majority Element II" problem. The objective is to find all elements that appear strictly more than $N/3$ times in an array of size $N$. Mathematically, there can be at most two such elements.

## 1. Brute Force Approach (`bruteForce`)
Checks the exact count of every element in the array one by one.
*   **Approach:** Uses nested loops. The outer loop selects an element, and the inner loop counts its total occurrences across the entire array. If the count exceeds $N/3$ and the element is not already in the result list, it is added. The loop terminates early if two majority elements are found.
*   **Time Complexity (TC):** $O(N^2)$ - Compares every element against every other element.
*   **Space Complexity (SC):** $O(1)$ - (Excluding the space used to return the answer).

## 2. Hashing Approach (`Better`)
Maintains a running frequency count using a HashMap.
*   **Approach:** Iterates through the array and stores/updates the frequency of each element in a `HashMap`. The moment an element's frequency hits exactly `(N/3) + 1`, it is guaranteed to be a majority element and is added to the result list. 
*   **Time Complexity (TC):** $O(N)$ - Single pass through the array. HashMap insertions take $O(1)$ on average.
*   **Space Complexity (SC):** $O(N)$ - In the worst-case scenario, the map stores $N$ unique key-value pairs.

## 3. Optimal Approach: Extended Moore's Voting Algorithm (`Optimal`)
An advanced variation of Moore's Voting Algorithm that tracks two potential candidates simultaneously, eliminating the need for extra memory.
*   **Approach Breakdown:**
    1.  **Phase 1 (Finding Candidates):** Maintains two candidate variables (`ele1`, `ele2`) and two counters (`cnt1`, `cnt2`). As the array is traversed, if the current element matches a candidate, its counter increments. If a counter is zero, the current element becomes a new candidate. If the current element matches neither candidate, both counters are decremented. 
    2.  **Phase 2 (Verification):** Because the array might not contain any majority elements, a second pass counts the exact occurrences of the two surviving candidates to verify if they truly appear more than $N/3$ times.
*   **Time Complexity (TC):** $O(N)$ - Requires exactly two linear passes through the array.
*   **Space Complexity (SC):** $O(1)$ - Only uses four integer variables, completely bypassing the memory overhead of a HashMap.