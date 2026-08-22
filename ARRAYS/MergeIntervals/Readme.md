# Merge Intervals

**Author:** Md Baktiyar

This repository contains an optimal Java solution for merging overlapping intervals using a primitive array buffer approach.

## Optimal Solution (Array Buffer)
This approach avoids the overhead of Java Object boxing (`ArrayList`, `Integer`) by using primitive 2D arrays to merge overlapping intervals in place.

*   **Approach:**
    1. **Sort:** Sort the input array based on the starting times of the intervals. 
    2. **Buffer Allocation:** Allocate a temporary 2D array `tem` of size $N \times 2$ to hold the maximum possible number of merged intervals.
    3. **Merge:** Iterate through the sorted intervals. Maintain an index pointer `idx` for the `tem` array. If the current interval's start time overlaps with the `tem[idx]` end time, update the end time to the maximum of both. Otherwise, increment `idx` and add the current interval as a new block.
    4. **Trim:** Copy the valid merged intervals from the `tem` buffer into an exactly sized result array to eliminate empty trailing rows.
*   **Time Complexity (TC):** $O(N \log N)$ - The time is dominated by the sorting step. The subsequent linear scan takes $O(N)$ time.
*   **Space Complexity (SC):** $O(N)$ - In the worst-case scenario (no overlapping intervals), the temporary array `tem` requires $O(N)$ space.