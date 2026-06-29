# Reverse Linked List

## Problem

Given the head of a singly linked list, reverse the linked list and return the new head.

---

## Example

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5
```

**Output**

```text
5 -> 4 -> 3 -> 2 -> 1
```

---

# Approach 1: Brute Force

### Idea

* Traverse the linked list and store all node values in an array or list.
* Traverse the linked list again.
* Replace the node values from the array in reverse order.
* The node links remain unchanged; only the values are updated.

### Algorithm

1. Traverse the linked list and store each node's value in an array.
2. Start from the head again.
3. Assign values from the array in reverse order.
4. Return the head.

### Time Complexity

```text
O(N)
```

### Space Complexity

```text
O(N)
```

---

# Approach 2: Optimal (Three Pointer Technique)

### Idea

Reverse the links between nodes instead of storing values.

Maintain three pointers:

* **Previous (prev)**
* **Current (curr)**
* **Next (next)**

At every step:

* Save the next node.
* Reverse the current node's link.
* Move all three pointers one step forward.

After the traversal, the previous pointer becomes the new head.

### Algorithm

1. Initialize:

   * `prev = null`
   * `curr = head`
2. While `curr != null`

   * Store `next = curr.next`
   * Reverse the link: `curr.next = prev`
   * Move `prev = curr`
   * Move `curr = next`
3. Return `prev`.

---

## Time Complexity

```text
O(N)
```

---

## Space Complexity

```text
O(1)
```

---

## Comparison

| Approach                  | Time | Space | Preferred |
| ------------------------- | ---- | ----- | --------- |
| Brute Force (Using Array) | O(N) | O(N)  | ❌ No      |
| Optimal (Three Pointers)  | O(N) | O(1)  | ✅ Yes     |

---

## Concepts Used

* Linked List
* Pointer Manipulation
* Three Pointer Technique
* In-place Reversal

---

## Learning

* Learned that a linked list can be reversed either by changing node values or by reversing the links.
* The three-pointer technique performs the reversal in-place without using extra memory.
* Proper pointer ordering is essential to avoid losing access to the remaining list.
* This technique is widely used in advanced linked list problems such as reversing a sublist, reversing nodes in groups, and checking for palindromes.

---

## File

```text
ReverseLL.java
```
