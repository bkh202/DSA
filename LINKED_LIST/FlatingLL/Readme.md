# Flatten a Linked List (Java)

This project demonstrates two approaches to **flatten a multi-level linked list** into a single sorted linked list using Java.

Each node contains:

- `next` → points to the next linked list.
- `child` → points to the next node within the same linked list.

The goal is to merge all child lists into one sorted list using the `child` pointer.

---

# Problem Statement

Given a linked list where every node has:

- `next` pointer
- `child` pointer

Each child list is already sorted.

Flatten the entire structure into one sorted linked list using only the `child` pointer.

---

# Example

### Input

```
5 → 10 → 19 → 28
|    |     |     |
7    20    22    35
|          |     |
8          50    40
|                |
30               45
```

### Output

```
5
↓
7
↓
8
↓
10
↓
19
↓
20
↓
22
↓
28
↓
30
↓
35
↓
40
↓
45
↓
50
```

---

# Approaches

## 1. Brute Force Approach

### Idea

- Traverse every linked list.
- Store all node values in an `ArrayList`.
- Sort the array.
- Convert the sorted array back into a linked list.

### Algorithm

1. Traverse every node using `next`.
2. Traverse each child list using `child`.
3. Store all values in an `ArrayList`.
4. Sort the array.
5. Create a new linked list from the sorted values.
6. Return the head.

### Time Complexity

```
O(N × M + K log K)
```

Where:

- `K` = Total number of nodes

### Space Complexity

```
O(K)
```

---

## 2. Optimized Approach (Recursive Merge)

### Idea

Instead of storing all values, recursively flatten the remaining linked lists and merge two sorted child lists.

This approach is similar to the Merge step in Merge Sort.

### Algorithm

1. If only one list remains, return it.
2. Recursively flatten the remaining lists.
3. Merge the current list with the flattened list.
4. Return the merged list.

### Merge Process

- Compare nodes from both child lists.
- Attach the smaller node.
- Move forward.
- Continue until one list ends.
- Attach the remaining nodes.

### Time Complexity

```
O(K × N)
```

Where:

- `K` = Number of linked lists
- `N` = Average nodes per list

> A divide-and-conquer merge strategy can improve this to **O(T log K)**, where `T` is the total number of nodes.

### Space Complexity

```
O(K)
```

(Recursive call stack)

---

# Project Structure

```
LINKED_LIST
│
└── FlatingLL
    │
    ├── Node.java
    └── FlatOfLL.java
```

---

# Methods

## Convert Array to Linked List

```java
public static Node convertArrTOLL(ArrayList<Integer> arr)
```

Creates a child linked list from a sorted array.

---

## Brute Force Flatten

```java
public static Node Flating(Node head)
```

Stores all values, sorts them, and builds a new flattened linked list.

---

## Merge Two Sorted Child Lists

```java
public static Node merge(Node list1, Node list2)
```

Merges two sorted linked lists connected through the `child` pointer.

---

## Optimized Flatten

```java
public static Node flatten(Node root)
```

Recursively flattens the linked list using merge operations.

---

# Comparison

| Approach | Time Complexity | Space Complexity | Extra Space |
|----------|-----------------|------------------|-------------|
| Brute Force | O(K + K log K) | O(K) | Yes |
| Recursive Merge | O(K × N) *(or O(T log K) with divide & conquer)* | O(K) | No additional data structure |

---

# Key Concepts

- Multi-Level Linked List
- Recursion
- Merge Two Sorted Linked Lists
- Divide and Conquer
- Linked List Traversal
- Sorting
- Dummy Node Technique

---

# Learning Outcomes

After completing this implementation, you will understand:

- How to flatten a multi-level linked list.
- Difference between brute-force and optimized solutions.
- How recursive linked list merging works.
- How to merge two sorted linked lists efficiently.
- Why recursion is useful for linked list problems.

---

# Author

**Md Bakhtiyar**