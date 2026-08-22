# Best Time to Buy and Sell Stock

**Author:** Md Baktiyar

This repository contains Java solutions for variations of the classic "Best Time to Buy and Sell Stock" problem.

## 1. Single Transaction Allowed (Brute Force)
Checks every possible pair of buy and sell days to find the maximum profit.
*   **Approach:** Iterate through the array with nested loops. For every element `arr[i]`, compare it with every subsequent element `arr[j]` to calculate the profit. Update the maximum profit if `arr[j] - arr[i]` is greater than the current maximum.
*   **Time Complexity (TC):** $O(N^2)$ - Nested loops iterating over the array elements.
*   **Space Complexity (SC):** $O(1)$ - No extra space used.

## 2. Single Transaction Allowed (Optimal)
Finds the maximum profit in a single pass by keeping track of the lowest price seen so far.
*   **Approach:** Iterate through the array once. Maintain a variable for the minimum price encountered so far. At each step, calculate the potential profit if sold today (current price - minimum price) and update the maximum profit accordingly.
*   **Time Complexity (TC):** $O(N)$ - Single pass through the array.
*   **Space Complexity (SC):** $O(1)$ - Only using a few variables for tracking.

## 3. Multiple Transactions Allowed
Finds the maximum profit when you can buy and sell on multiple days (but can only hold one stock at a time).
*   **Approach:** Greedy algorithm. Iterate through the array and whenever the price on day `i` is greater than the price on day `i-1`, capture that profit. This effectively accumulates all upward price trends.
*   **Time Complexity (TC):** $O(N)$ - Single pass through the array.
*   **Space Complexity (SC):** $O(1)$ - No extra space used.