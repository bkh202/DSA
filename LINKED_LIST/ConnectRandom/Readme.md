# Clone a Linked List with Random Pointer (Optimal Approach)

## Problem Statement

Given a linked list where each node contains:

- `data`
- `next` pointer
- `random` pointer (can point to any node in the list or `null`)

Create a **deep copy** of the linked list such that:

- Every node is newly created.
- The `next` pointers are preserved.
- The `random` pointers point to the corresponding cloned nodes.
- The original linked list remains unchanged.

---

# Approach

The optimal solution avoids using extra data structures like a `HashMap` by modifying the original linked list temporarily.

The algorithm consists of **three steps**.

---

## Step 1: Insert Copy Nodes

Create a copy of every original node and insert it immediately after the original node.

### Before

```
1 → 2 → 3
```

### After

```
1 → 1' → 2 → 2' → 3 → 3'
```

This arrangement makes it easy to locate the cloned version of any original node.

---

## Step 2: Connect Random Pointers

Each copied node's random pointer is assigned using the original node's random pointer.

Since every copied node is placed immediately after its original node, the copied random node can be accessed directly.

### Example

Original

```
1.random → 3
```

After inserting copies

```
1 → 1' → 2 → 2' → 3 → 3'
```

The copied node's random becomes

```
1'.random → 3'
```

---

## Step 3: Separate the Two Lists

After assigning all random pointers, the original and copied nodes are interleaved.

The final step restores the original linked list and extracts the cloned linked list.

### Before Separation

```
1 → 1' → 2 → 2' → 3 → 3'
```

### After Separation

Original List

```
1 → 2 → 3
```

Copied List

```
1' → 2' → 3'
```

---

# Dry Run

Original List

```
7 → 14 → 21 → 28
```

Random Connections

```
7  → 21
14 → 7
21 → 28
28 → 14
```

After Step 1

```
7 → 7' → 14 → 14' → 21 → 21' → 28 → 28'
```

After Step 2

```
7'.random  → 21'
14'.random → 7'
21'.random → 28'
28'.random → 14'
```

After Step 3

Original

```
7 → 14 → 21 → 28
```

Copied

```
7' → 14' → 21' → 28'
```

---

# Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert copied nodes | O(N) |
| Assign random pointers | O(N) |
| Separate both lists | O(N) |

### Overall Time Complexity

```
O(N)
```

---

# Space Complexity

```
O(1)
```

No extra data structures are used. The copied nodes themselves are not counted as extra space because they form the required output.

---

# Why This Approach is Optimal

- No `HashMap` is required.
- Only three traversals of the linked list.
- Constant auxiliary space.
- Efficient for large linked lists.
- Commonly asked in coding interviews.

---

# Edge Cases

- Empty linked list.
- Single-node linked list.
- Random pointer is `null`.
- Random pointer points to itself.
- Multiple nodes point to the same random node.
- Random pointers form cycles.
- Large values of `N`.

---

# Common Mistakes

- Forgetting to insert copied nodes immediately after the originals.
- Incorrectly assigning random pointers.
- Not restoring the original linked list after cloning.
- Breaking the copied list while separating.
- Forgetting to handle `null` random pointers.
- Losing track of the original head during traversal.

---

# Complexity Summary

| Approach | Time | Space |
|----------|------|-------|
| HashMap-Based | O(N) | O(N) |
| Optimal Interleaving Method | O(N) | O(1) |

---

# Key Takeaways

- The algorithm temporarily interleaves copied nodes with the original nodes.
- Random pointers can be assigned without any extra mapping.
- The final step separates the two lists while restoring the original linked list.
- The optimal solution achieves **O(N)** time complexity with **O(1)** auxiliary space, making it the preferred approach for interviews and production implementations.

# Author
 **Md Bakhtiyar**