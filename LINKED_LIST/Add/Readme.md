# Add Two Linked Lists

## Problem

Given two non-empty linked lists representing two non-negative integers, where each node contains a single digit, add the two numbers and return the sum as a linked list.

The digits are stored in forward order (or reverse order depending on the problem statement). Each linked list represents one number.

---

## Example

**Input**

```
List 1: 4 -> 5
List 2: 3 -> 4 -> 5
```

**Output**

```
3 -> 9 -> 0
```

---

## Approach

* Traverse both linked lists simultaneously.
* Add the corresponding digits.
* Maintain a carry for sums greater than or equal to 10.
* Create a new node for each resulting digit.
* Continue until both lists are fully traversed and no carry remains.

---

## Algorithm

1. Initialize a dummy node.
2. Maintain a pointer to build the result list.
3. Traverse both linked lists.
4. Compute:

   * `sum = digit1 + digit2 + carry`
5. Store:

   * `digit = sum % 10`
   * `carry = sum / 10`
6. Append the new digit to the result list.
7. Move to the next nodes.
8. Return the result linked list.

---

## Time Complexity

```
O(max(N, M))
```

Where:

* **N** = Length of first linked list
* **M** = Length of second linked list

---

## Space Complexity

```
O(max(N, M))
```

Extra space is used only for the resulting linked list.

---

## Concepts Used

* Linked List Traversal
* Dummy Node
* Carry Handling
* Simulation
* Pointer Manipulation

---

## Learning

* How to traverse two linked lists simultaneously.
* How to manage carry during addition.
* Importance of using a dummy node to simplify list construction.
* Handling linked lists of different lengths efficiently.

---

## File

```
AddTwoLL.java
```
