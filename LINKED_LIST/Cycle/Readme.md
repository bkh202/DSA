# Detect Cycle in Linked List (Java)

This project demonstrates two popular approaches to detect whether a **Linked List contains a cycle (loop)**.

## Problem Statement

Given the head of a singly linked list, determine whether the linked list contains a cycle.

A cycle exists if a node can be reached again by continuously following the `next` pointer.

---

## Approaches Used

### 1. HashMap Approach

This approach stores every visited node inside a `HashMap`.

- Traverse the linked list.
- If the current node already exists in the map, a cycle is present.
- Otherwise, store the node and continue.

### Time Complexity

- **O(n)**

### Space Complexity

- **O(n)**

---

### 2. Floyd's Cycle Detection Algorithm (Tortoise and Hare)

This is the most optimized solution.

It uses two pointers:

- **Slow Pointer** → Moves one step at a time.
- **Fast Pointer** → Moves two steps at a time.

If a cycle exists, both pointers will eventually meet.

If the fast pointer reaches `null`, then no cycle exists.

### Time Complexity

- **O(n)**

### Space Complexity

- **O(1)**

---

## Project Structure

```
LINKED_LIST/
└── Cycle/
    ├── DetectCycle.java
```

---

## Code Overview

### Node Class

```java
class Node {
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}
```

Represents a node of the linked list.

---

### Method 1

```java
public static boolean Cycle(Node head)
```

Detects a cycle using a `HashMap`.

---

### Method 2

```java
public static boolean Cycle2(Node head)
```

Detects a cycle using Floyd's Tortoise and Hare Algorithm.

---

## Example

### Linked List without Cycle

```
1 → 2 → 3 → 4 → null
```

Output

```
false
```

---

### Linked List with Cycle

```
1 → 2 → 3 → 4
     ↑       ↓
     └───────┘
```

Output

```
true
```

---

## Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| HashMap | O(n) | O(n) |
| Floyd's Algorithm | O(n) | O(1) |

---

## Note

There is a small issue in the `Cycle()` (HashMap) method.

Current code:

```java
temp = temp.next;
mp.put(temp, 1);
```

This skips storing the current node and instead stores the next node, which may produce incorrect results.

Correct implementation:

```java
while (temp != null) {
    if (mp.containsKey(temp)) {
        return true;
    }

    mp.put(temp, 1);
    temp = temp.next;
}
```

---

## Learning Outcomes

- Understanding Linked List traversal.
- Detecting loops using extra memory.
- Learning Floyd's Cycle Detection Algorithm.
- Comparing time and space complexity.
- Writing optimized Linked List solutions in Java.

---

## Author

**Md Bakhtiyar**

Java Full Stack Developer