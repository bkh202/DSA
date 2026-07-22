# Rotate Linked List (Java)

## Overview

Rotating a linked list means shifting the nodes either to the left or the right by `k` positions while maintaining the relative order of the remaining nodes.

Example:

```
Original:
1 → 2 → 3 → 4 → 5

Left Rotate by 2:
3 → 4 → 5 → 1 → 2

Right Rotate by 2:
4 → 5 → 1 → 2 → 3
```

---

# Approach 1: Brute Force

## Idea

Rotate the linked list **one position at a time** and repeat this process `k` times.

Each rotation requires traversing the entire linked list to locate the last node (or first node for left rotation), making this approach simple but inefficient for large values of `k`.

### Time Complexity

```
O(N × K)
```

### Space Complexity

```
O(1)
```

### Advantages

- Easy to understand.
- Easy to implement.
- No extra memory required.

### Disadvantages

- Inefficient for large values of `k`.
- Traverses the linked list multiple times.

---

# Approach 2: Optimal

## Idea

Instead of rotating one step at a time:

1. Find the length of the linked list.
2. Reduce unnecessary rotations using modulo (`k % length`).
3. Convert the linked list into a circular linked list.
4. Locate the new breaking point.
5. Break the circle to obtain the rotated linked list.

This approach traverses the list only once (or nearly once), making it significantly faster.

### Time Complexity

```
O(N)
```

### Space Complexity

```
O(1)
```

### Advantages

- Efficient for large linked lists.
- Handles very large values of `k`.
- Only one traversal is required.

### Disadvantages

- Slightly more complex than the brute-force approach.
- Requires careful handling of edge cases.

---

# Edge Cases

- Empty linked list.
- Single-node linked list.
- `k = 0`.
- `k` greater than the length of the linked list.
- `k` equal to the length of the linked list.
- Very large values of `k`.

---

# Common Mistakes

- Incorrectly calculating the length of the linked list.
- Using `length % k` instead of `k % length`.
- Forgetting to handle `k = 0`.
- Not breaking the circular linked list after rotation.
- Losing the reference to the head or tail node.
- Incorrectly identifying the new head after rotation.

---

# Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|----------|-----------------|------------------|
| Brute Force | O(N × K) | O(1) |
| Optimal | O(N) | O(1) |

---

# Key Takeaways

- The brute-force approach is suitable for learning but is inefficient for large inputs.
- The optimal approach uses modulo arithmetic and a circular linked list to reduce the time complexity from **O(N × K)** to **O(N)**.
- Both approaches use **constant extra space**, but the optimal solution is preferred in coding interviews and production code.

# Author

**Md Bakhtiyar**