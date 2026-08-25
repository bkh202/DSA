# Calculate Power (Binary Exponentiation)

**Author:** Md Baktiyar

This repository contains a highly optimized Java solution to calculate $b^e$ (a base `b` raised to an integer exponent `e`). It is robust enough to handle negative exponents and integer overflow edge cases safely.

## Optimal Approach: Binary Exponentiation
Instead of multiplying the base $N$ times (which takes $O(N)$ time and results in a Time Limit Exceeded error on large inputs), this algorithm uses **Exponentiation by Squaring** to halve the number of required operations at each step.

*   **Approach Breakdown:**
    1.  **Overflow Prevention:** The 32-bit integer exponent is immediately cast to a 64-bit `long`. This prevents an integer overflow crash if the input exponent is exactly `Integer.MIN_VALUE` ($-2147483648$) when converting it to a positive number for the loop.
    2.  **Odd vs. Even Halving:** 
        *   If the exponent is **even**, we square the base and divide the exponent by 2. (e.g., $2^{10} \rightarrow 4^5$).
        *   If the exponent is **odd**, we multiply the current running answer by the base and subtract 1 from the exponent. (e.g., $4^5 \rightarrow 4 \times 4^4$).
    3.  **Negative Exponents:** The core loop calculates the power using the absolute value of the exponent. Afterward, we check the original input exponent. If it was negative, we return the mathematical reciprocal ($1.0 / \text{answer}$).
*   **Time Complexity (TC):** $O(\log N)$ - The exponent is halved at every step, reducing massive calculations to a fraction of the time.
*   **Space Complexity (SC):** $O(1)$ - The calculation is strictly mathematical and uses no extra auxiliary space.