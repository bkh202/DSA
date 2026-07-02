# Reverse Linked List in Groups of K (Java)

## Overview

This project implements the **Reverse Nodes in K-Group** problem using an **iterative in-place approach**.

The algorithm reverses the nodes of a linked list in groups of size `k` while maintaining **O(1)** extra space.

---

## Problem Statement

Given the head of a singly linked list and an integer `k`, reverse the nodes of the list `k` at a time and return the modified list.

* If the number of remaining nodes is less than `k`, they may remain unchanged (depending on the implementation).
* The values inside nodes cannot be modified—only the node links are changed.

---

## Project Structure

```text
LINKED_LIST/
└── ReverseGroupK/
    └── ReverseGroupOfK.java
```

---

## Node Structure

```java
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
```

Each node contains:

* `val` – Stores the data.
* `next` – Points to the next node.

---

## Algorithm

1. Handle edge cases.
2. Count the total number of nodes.
3. Create a dummy node before the head.
4. Reverse each group of `k` nodes using pointer manipulation.
5. Connect the reversed group with the remaining list.
6. Return the new head.

---

## Java Method

```java
public static Node GroupReverse(Node head, int k)
```

### Parameters

| Parameter | Description             |
| --------- | ----------------------- |
| `head`    | Head of the linked list |
| `k`       | Size of each group      |

### Returns

Returns the head of the modified linked list.

---

## Example

### Input

```text
Linked List

1 → 2 → 3 → 4 → 5 → 6 → 7 → 8

k = 3
```

### Output

```text
3 → 2 → 1 → 6 → 5 → 4 → 7 → 8
```

---

## Dry Run

Original List

```text
1 → 2 → 3 → 4 → 5 → 6
```

After reversing first group (`k = 3`)

```text
3 → 2 → 1 → 4 → 5 → 6
```

After reversing second group

```text
3 → 2 → 1 → 6 → 5 → 4
```

---

## Complexity Analysis

| Operation | Complexity |
| --------- | ---------- |
| Time      | **O(n)**   |
| Space     | **O(1)**   |

Where `n` is the number of nodes in the linked list.

---

## Features

* Iterative solution.
* In-place reversal.
* Constant extra memory.
* Uses a dummy node to simplify pointer handling.
* Suitable for coding interviews.

---

## Note

There is a small issue in the current implementation.

This line:

```java
int groupSize = Math.max(k, count);
```

should be:

```java
int groupSize = Math.min(k, count);
```

Using `Math.max()` can cause the algorithm to attempt reversing more nodes than remain in the list, potentially resulting in a `NullPointerException`.

If the requirement is to reverse **only complete groups of `k`**, the outer loop should also be:

```java
while (count >= k)
```

instead of:

```java
while (count > 0)
```

---

## Learning Outcomes

* Linked List traversal.
* Dummy node technique.
* In-place reversal.
* Pointer manipulation.
* Group-based linked list algorithms.
* Time and space complexity analysis.

---

## Author

**Md Bakhtiyar**

Java Full Stack Developer
