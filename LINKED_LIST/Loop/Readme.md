# Start Point of Loop in Linked List

This project demonstrates two approaches to find the **starting node of a loop (cycle)** in a singly linked list using Java.

## Problem Statement

Given the head of a linked list, determine whether a loop exists.

If a loop exists, return the **first node where the loop begins**.

If no loop exists, return `null`.

---

## Approaches

### 1. Brute Force Approach (HashMap)

This approach stores every visited node in a `HashMap`.

- Traverse the linked list.
- If a node is already present in the map, that node is the starting point of the loop.
- Otherwise, store the node and continue.

### Algorithm

1. Create a `HashMap`.
2. Traverse the linked list.
3. If current node already exists in the map:
   - Return the current node.
4. Otherwise store the node.
5. If traversal reaches `null`, no loop exists.

### Time Complexity

```
O(N)
```

### Space Complexity

```
O(N)
```

---

## 2. Optimized Approach (Floyd's Cycle Detection)

Also known as the **Tortoise and Hare Algorithm**.

### Idea

- Use two pointers:
  - `slow` moves one step.
  - `fast` moves two steps.
- If they meet, a cycle exists.
- Move another pointer (`entry`) from the head.
- Move both `slow` and `entry` one step at a time.
- The point where they meet is the **starting node of the loop**.

### Algorithm

1. Initialize:
   - `slow = head`
   - `fast = head`
   - `entry = head`
2. Move:
   - `slow = slow.next`
   - `fast = fast.next.next`
3. If `slow == fast`:
   - Move both `slow` and `entry` one step at a time.
   - Their meeting point is the start of the loop.
4. If `fast` reaches `null`, no loop exists.

### Time Complexity

```
O(N)
```

### Space Complexity

```
O(1)
```

---

# Code Structure

```
LINKED_LIST
│
└── LoopDection
    │
    ├── Node.java
    └── StartPointOfLoop.java
```

---

# Methods

### Brute Force

```java
public static Node startPointOfLoop(Node head)
```

Returns the first node where the cycle begins using a `HashMap`.

---

### Optimized

```java
public static Node startPointOfLoopOptimize(Node head)
```

Returns the first node where the cycle begins using Floyd's Cycle Detection Algorithm.

---

# Example

## Linked List

```
1 → 2 → 3 → 4 → 5
          ↑     ↓
          └─────┘
```

The loop starts at node **3**.

### Output

```
Start of Loop = 3
```

---

# Comparison

| Approach | Time | Space | Extra Memory |
|----------|------|--------|--------------|
| HashMap | O(N) | O(N) | Yes |
| Floyd's Algorithm | O(N) | O(1) | No |

---

# Key Learning

- A `HashMap` provides a simple solution but requires extra memory.
- Floyd's Cycle Detection Algorithm is the most efficient approach as it uses constant extra space.
- After detecting a cycle, moving one pointer from the head and another from the meeting point guarantees they meet at the loop's starting node.

---

## Author

**Md Bakhtiyar**