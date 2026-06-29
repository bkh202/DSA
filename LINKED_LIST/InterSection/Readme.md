# Intersection of Two Linked Lists

## Problem

Given the heads of two singly linked lists, determine the node at which the two linked lists intersect.

If the two linked lists do not intersect, return `null`.

**Note:** Two linked lists intersect only if they share the same node reference, not merely the same value.

---

## Example

**Input**

```text
List 1: 4 -> 1 \
               8 -> 4 -> 5
List 2:    5 -> 6 -> 1 /
```

**Output**

```text
8
```

---

# Approach 1: Brute Force

### Idea

* Traverse every node of the second linked list.
* For each node, traverse the entire first linked list.
* If both node references are the same, that node is the intersection.

### Algorithm

1. Traverse the second linked list.
2. For each node in the second list:

   * Traverse the first linked list.
   * Compare node references (`temp == l2`).
3. Return the first matching node.
4. If no match is found, return `null`.

---

## Time Complexity

```text
O(N × M)
```

Where:

* **N** = Length of first linked list
* **M** = Length of second linked list

---

## Space Complexity

```text
O(1)
```

---

# Approach 2: Better (Using HashSet)

### Idea

* Store all nodes of the first linked list in a `HashSet`.
* Traverse the second linked list.
* The first node already present in the `HashSet` is the intersection.

### Algorithm

1. Create a `HashSet<Node>`.
2. Store every node of the first linked list.
3. Traverse the second linked list.
4. If the current node exists in the `HashSet`, return it.
5. Otherwise continue.
6. If no intersection exists, return `null`.

---

## Time Complexity

```text
O(N + M)
```

---

## Space Complexity

```text
O(N)
```

Extra space is required to store nodes of the first linked list.

---

# Optimal Approach (Two Pointers)

### Idea

* Initialize two pointers, one for each linked list.
* Traverse both lists simultaneously.
* When a pointer reaches the end of its list, move it to the head of the other list.
* If an intersection exists, both pointers will meet at the intersection node.
* Otherwise, both pointers will eventually become `null`.

### Algorithm

1. Initialize:

   * `p1 = head1`
   * `p2 = head2`
2. While `p1 != p2`:

   * If `p1` is `null`, move it to `head2`; otherwise move to `p1.next`.
   * If `p2` is `null`, move it to `head1`; otherwise move to `p2.next`.
3. Return `p1` (intersection node or `null`).

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

---

## Comparison

| Approach               | Time Complexity | Space Complexity | Preferred |
| ---------------------- | --------------- | ---------------- | --------- |
| Brute Force            | O(N × M)        | O(1)             | ❌ No      |
| Better (HashSet)       | O(N + M)        | O(N)             | ✔️ Good   |
| Optimal (Two Pointers) | O(N + M)        | O(1)             | ✅ Best    |

---

## Concepts Used

* Linked List
* Node Reference Comparison
* HashSet
* Two Pointer Technique

---

## Learning

* Learned that linked list intersection is determined by **node reference**, not by node value.
* The brute force approach checks every possible pair of nodes.
* Using a `HashSet` improves the time complexity by storing visited nodes.
* The two-pointer approach achieves **O(N + M)** time with **O(1)** extra space, making it the most efficient solution.

---

## File

```text
InterSectionOfLL.java
```
