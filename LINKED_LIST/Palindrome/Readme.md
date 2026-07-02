# Palindrome Linked List (Java)

## Overview

This project demonstrates two approaches to determine whether a **singly linked list is a palindrome**.

A linked list is considered a palindrome if it reads the same forward and backward.

Examples:

```text
1 → 2 → 3 → 2 → 1   ✅ Palindrome

1 → 2 → 2 → 1       ✅ Palindrome

1 → 2 → 3           ❌ Not a Palindrome
```

---

## Problem Statement

Given the head of a singly linked list, determine whether the list is a palindrome.

Return:

* `true` if the linked list is a palindrome.
* `false` otherwise.

---

## Project Structure

```text
LINKED_LIST/
└── Palindrome/
    └── Palindrome.java
```

---

## Approaches Used

### 1. Brute Force (Using Stack)

Store all node values in a stack.

* Traverse the linked list and push every value onto the stack.
* Traverse the list again.
* Compare each node's value with the top of the stack.
* If all values match, the list is a palindrome.

### Time Complexity

**O(n)**

### Space Complexity

**O(n)**

---

### 2. Optimal Approach (Slow/Fast Pointer + Reverse)

This approach avoids using extra memory.

Algorithm:

1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the list.
3. Compare the first half with the reversed second half.
4. If all nodes match, the list is a palindrome.

### Time Complexity

**O(n)**

### Space Complexity

**O(1)**

---

## Java Methods

### Brute Force

```java
public static boolean palindrome(Node head)
```

Checks whether the linked list is a palindrome using a stack.

---

### Reverse Linked List

```java
public static Node Reverse(Node head)
```

Reverses a linked list and returns the new head.

---

### Optimal Solution

```java
public static boolean PalindromeLL(Node head)
```

Checks whether the linked list is a palindrome using the two-pointer technique and in-place reversal.

---

## Example

### Input

```text
1 → 2 → 3 → 2 → 1
```

### Output

```text
true
```

---

### Input

```text
1 → 2 → 3 → 4
```

### Output

```text
false
```

---

## Complexity Comparison

| Approach            | Time | Space |
| ------------------- | ---- | ----- |
| Stack               | O(n) | O(n)  |
| Reverse Second Half | O(n) | O(1)  |

---

## Algorithms Used

* Stack
* Slow & Fast Pointer Technique
* In-place Linked List Reversal
* Two Pointer Technique

---

## Learning Outcomes

* Finding the middle of a linked list.
* Reversing a linked list.
* Checking for palindromes efficiently.
* Comparing brute-force and optimized approaches.
* Understanding pointer manipulation in linked lists.

---

## Note

There are two small issues in the current implementation:

### 1. Stack Approach

After comparing with the top element, the stack should also remove that element.

Current code:

```java
if(temp.val != s.peek())
```

Correct version:

```java
if(temp.val != s.pop())
```

Otherwise, every comparison checks the same top value.

---

### 2. Reverse Method

Current code:

```java
curr = prev;
prev = curr;
curr = front;
```

This does not reverse the links.

Correct implementation:

```java
while (curr != null) {
    Node front = curr.next;
    curr.next = prev;
    prev = curr;
    curr = front;
}
```

Without this correction, the optimal solution will not work as expected.

---

## Author

**Md Bakhtiyar**

Java Full Stack Developer
