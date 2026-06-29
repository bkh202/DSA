# Merge Two Sorted Linked Lists

## Problem

Given the heads of two sorted singly linked lists, merge them into a single sorted linked list and return its head.

The merged linked list should also be sorted in non-decreasing order.

---

## Example

**Input**

```text
List 1: 1 -> 3 -> 5
List 2: 2 -> 4 -> 6
```

**Output**

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

---

# Approach 1: Brute Force (Using ArrayList)

### Idea

* Traverse both linked lists and store all elements in an `ArrayList`.
* Sort the list using `Collections.sort()`.
* Create a new linked list from the sorted values.

### Algorithm

1. Traverse the first linked list and store all values in an `ArrayList`.
2. Traverse the second linked list and store all values.
3. Sort the `ArrayList`.
4. Create a new linked list from the sorted values.
5. Return the head of the new linked list.

### Time Complexity

```text
O((N + M) log(N + M))
```

Where:

* **N** = Length of first linked list
* **M** = Length of second linked list

### Space Complexity

```text
O(N + M)
```

Extra space is used for the `ArrayList` and the newly created linked list.

---

# Approach 2: Optimal (Two Pointer Technique)

### Idea

* Since both linked lists are already sorted, compare the current nodes of both lists.
* Attach the smaller node to the merged list.
* Move the corresponding pointer forward.
* Continue until one list is exhausted.
* Attach the remaining nodes directly.

No additional data structure is required.

### Algorithm

1. Create a dummy node.
2. Maintain a pointer `temp` for building the merged list.
3. Compare the current nodes of both lists.
4. Append the smaller node to the result.
5. Move the corresponding pointer.
6. Repeat until one list becomes empty.
7. Attach the remaining nodes of the non-empty list.
8. Return `dummy.next`.

---

## Time Complexity

```text
O(N + M)
```

---

## Space Complexity

```text
O(1)
```

No extra space is used. Existing nodes are reused.

---

## Comparison

| Approach                          | Time Complexity       | Space Complexity | Preferred |
| --------------------------------- | --------------------- | ---------------- | --------- |
| Brute Force (ArrayList + Sorting) | O((N + M) log(N + M)) | O(N + M)         | ❌ No      |
| Optimal (Two Pointers)            | O(N + M)              | O(1)             | ✅ Yes     |

---

## Concepts Used

* Linked List
* Two Pointer Technique
* Dummy Node
* ArrayList
* Sorting
* In-place Merge

---

## Learning

* Learned how to merge two sorted linked lists using two different approaches.
* The brute force approach is simple but requires extra memory and sorting.
* The optimal approach efficiently merges both lists in a single traversal by reusing existing nodes.
* Dummy nodes simplify linked list construction and eliminate special handling for the head node.

---

## File

```text
MergeTwoLL.java
```
