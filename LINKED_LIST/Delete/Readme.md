# Delete Nth Node From End of Linked List

## Problem

Given the head of a singly linked list and an integer `N`, delete the Nth node from the end of the list and return the modified head.

---

## Example

**Input**

```text
List: 1 -> 2 -> 3 -> 4 -> 5
N = 2
```

**Output**

```text
1 -> 2 -> 3 -> 5
```

---

## Approach (Optimal - Two Pointers)

### Idea

* Create a dummy node pointing to the head.
* Use two pointers (`slow` and `fast`).
* Move the `fast` pointer `N` steps ahead.
* Move both pointers together until `fast` reaches the last node.
* `slow` will be just before the node to delete.
* Remove the node by updating `slow.next`.

---

## Algorithm

1. Create a dummy node before the head.
2. Initialize `slow` and `fast` to the dummy node.
3. Move `fast` forward by `N` nodes.
4. Move both pointers one step at a time until `fast.next` becomes `null`.
5. Delete the target node by changing `slow.next`.
6. Return `dummy.next`.

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

## Concepts Used

* Linked List
* Dummy Node
* Two Pointer Technique
* Fast & Slow Pointer

---

## Learning

* Learned how dummy nodes simplify deletion at the head.
* Understood how two pointers can locate the Nth node from the end in a single traversal.
* Avoided calculating the total length of the linked list.

---

## File

```text
DeleteNodeFromX.java
```
# Delete Node in a Linked List

## Problem

You are given a node in a singly linked list. Delete the given node without access to the head of the linked list.

It is guaranteed that the given node is **not the last node**.

---

## Example

**Input**

```text
1 -> 2 -> 3 -> 4

Given Node = 3
```

**Output**

```text
1 -> 2 -> 4
```

---

## Approach

### Idea

* Copy the value of the next node into the current node.
* Skip the next node by updating the current node's next pointer.
* This effectively removes the given node.

---

## Algorithm

1. Copy the value of `node.next` into `node`.
2. Change `node.next` to `node.next.next`.
3. The next node is removed from the linked list.

---

## Time Complexity

```text
O(1)
```

---

## Space Complexity

```text
O(1)
```

---

## Concepts Used

* Linked List
* Pointer Manipulation
* In-place Deletion

---

## Learning

* Learned that deleting a node without the head is possible only when the node is **not the last node**.
* Instead of removing the current node, copy the next node's data and bypass it.
* This is one of the most frequently asked Linked List interview questions.

---

## File

```text
DeleteNode.java
```
