# Clone a Linked List with Random Pointer

## Problem Statement

Given a linked list where each node contains:

- `data`
- `next` pointer
- `random` pointer

Create a **deep copy** of the linked list such that:

- Every node in the cloned list is newly created.
- Both `next` and `random` pointers are preserved.
- The cloned list is completely independent of the original list.
- The original linked list remains unchanged.

---

# Approaches

There are two popular approaches to solve this problem:

1. **HashMap Based Approach**
2. **Optimal Interleaving Approach**

---

# Approach 1: HashMap Based

## Idea

Create a mapping between every original node and its cloned node using a `HashMap`.

The solution is performed in two passes:

- First pass creates cloned nodes.
- Second pass connects the `next` and `random` pointers using the stored mapping.

---

## Steps

### Step 1

Traverse the original linked list and create a clone of every node.

Store the mapping:

```
Original Node  →  Cloned Node
```

Example

```
1 → 2 → 3

HashMap

1 → 1'
2 → 2'
3 → 3'
```

---

### Step 2

Traverse the list again.

For every original node:

- Connect the cloned node's `next` pointer.
- Connect the cloned node's `random` pointer.

Since every cloned node already exists in the HashMap, pointer assignment becomes straightforward.

---

## Dry Run

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

After First Traversal

```
HashMap

7  → 7'
14 → 14'
21 → 21'
28 → 28'
```

After Second Traversal

```
7' → 14' → 21' → 28'

Random

7'  → 21'
14' → 7'
21' → 28'
28' → 14'
```

---

## Time Complexity

```
O(N)
```

---

## Space Complexity

```
O(N)
```

---

## Advantages

- Easy to understand.
- Easy to implement.
- Less pointer manipulation.
- Good for beginners.

---

## Disadvantages

- Requires extra memory.
- Not the most optimized solution.

---

# Approach 2: Optimal (Interleaving Method)

## Idea

Instead of using a `HashMap`, temporarily insert the cloned node immediately after every original node.

The algorithm consists of three traversals.

---

## Step 1: Insert Copy Nodes

Insert every cloned node immediately after its original node.

### Before

```
1 → 2 → 3
```

### After

```
1 → 1' → 2 → 2' → 3 → 3'
```

Now every copied node is located directly after its original node.

---

## Step 2: Connect Random Pointers

Since every copied node follows its original node, the copied random node can be accessed directly.

Example

Original

```
1.random → 3
```

After inserting copies

```
1 → 1' → 2 → 2' → 3 → 3'
```

Copied random becomes

```
1'.random → 3'
```

---

## Step 3: Separate Both Lists

Restore the original linked list while extracting the copied linked list.

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

## Dry Run

Original

```
7 → 14 → 21 → 28
```

Random

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

## Time Complexity

```
O(N)
```

---

## Space Complexity

```
O(1)
```

---

## Advantages

- No extra data structures required.
- Constant auxiliary space.
- Best solution for interviews.
- Highly efficient.

---

## Disadvantages

- Pointer manipulation is slightly complex.
- Easy to make mistakes while separating the two lists.

---

# Edge Cases

- Empty linked list.
- Single-node linked list.
- Random pointer is `null`.
- Random pointer points to itself.
- Multiple nodes share the same random pointer.
- Random pointers form cycles.
- Large linked lists.

---

# Common Mistakes

- Forgetting to handle `null` random pointers.
- Assigning the copied node's random pointer incorrectly.
- Losing the original linked list while separating.
- Breaking the copied list during extraction.
- Forgetting to restore the original linked list.
- Using node values instead of node references as HashMap keys.

---

# Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| HashMap Based | O(N) | O(N) |
| Optimal Interleaving | O(N) | O(1) |

---

# Which Approach Should You Choose?

| Scenario | Recommended Approach |
|----------|----------------------|
| Easy implementation | HashMap |
| Interview coding rounds | Optimal |
| Memory optimization | Optimal |
| Beginner-friendly | HashMap |
| Production with limited memory | Optimal |

---

# Key Takeaways

- Both approaches clone the linked list in **O(N)** time.
- The **HashMap approach** is simpler and easier to debug but requires **O(N)** extra space.
- The **Optimal Interleaving approach** eliminates the need for extra memory by temporarily modifying the original linked list.
- The optimal approach restores the original list after cloning and achieves **O(1)** auxiliary space, making it the preferred solution in coding interviews.

# Author
 **Md Bakhtiyar**