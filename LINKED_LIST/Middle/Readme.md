# Middle of Linked List

## Problem

Given the head of a singly linked list, find and return the middle node of the linked list.

If the linked list has two middle nodes, return the second middle node.

---

## Example

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5
```

**Output**

```text
3
```

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

**Output**

```text
4
```

---

## Approach

* Use two pointers:

  * **Slow Pointer** moves one node at a time.
  * **Fast Pointer** moves two nodes at a time.
* When the fast pointer reaches the end of the list, the slow pointer will be at the middle node.
* This eliminates the need to calculate the length of the linked list.

---

## Algorithm

1. Initialize two pointers:

   * `slow = head`
   * `fast = head`
2. Traverse the linked list while `fast` and `fast.next` are not `null`.
3. Move:

   * `slow` by one step.
   * `fast` by two steps.
4. When the loop ends, return `slow`.

---

## Time Complexity

```text
O(N)
```

Where **N** is the number of nodes in the linked list.

---

## Space Complexity

```text
O(1)
```

Only two pointers are used.

---

## Concepts Used

* Linked List
* Slow and Fast Pointer Technique
* Two Pointer Algorithm
* Efficient Traversal

---

## Learning

* Learned how the slow and fast pointer technique finds the middle node in a single traversal.
* Avoided counting the total number of nodes before finding the middle.
* Improved understanding of pointer movement in linked lists.
* This technique is also useful in problems like cycle detection and palindrome checking.

---

## File

```text
MidLL.java
```
