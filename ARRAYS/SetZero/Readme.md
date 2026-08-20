**# Set Matrix Zeroes**


**## Problem Statement**


Given an `n × m` matrix, if any element in the matrix is `0`, set its entire row and column to `0`.


The matrix should be modified **in-place**.


---


**# Example**


**Input**


```text
1  1  1
1  0  1
1  1  1

Output

1  0  1
0  0  0
1  0  1

# Approaches

There are three approaches implemented in this code:

Brute Force Approach
Better Approach
Optimal Approach

# Approach 1: Brute Force

## Idea

Traverse the complete matrix.

Whenever a 0 is found:

Mark every element in the same row as -1.
Mark every element in the same column as -1.
After completing the traversal, convert all -1 values into 0.

The temporary value -1 is used so that newly marked cells do not immediately affect the traversal.

## Steps

Step 1

Traverse every element of the matrix.

If:

mat[i][j] == 0

mark its corresponding row and column.

Step 2

Use -1 as a temporary marker.

Step 3

Traverse the matrix again and convert every -1 to 0.

## Example

Before:

1  2  3
4  0  6
7  8  9

After marking:

1  -1  3
-1  0  -1
7  -1  9

Final:

1  0  3
0  0  0
7  0  9

## Time Complexity

O(N × M × (N + M))

For every zero, we may traverse one complete row and one complete column.

## Space Complexity

O(1)

No additional arrays or data structures are used.

## Advantages

Simple to understand.
Easy to implement.
Does not require additional row and column arrays.

## Disadvantages

Inefficient for large matrices.
Repeatedly traverses rows and columns.
Uses -1 as a temporary marker.
If -1 is a valid value in the input matrix, this approach can produce incorrect results.

# Approach 2: Better

## Idea

Use two boolean arrays to keep track of which rows and columns contain 0.

row[] → Stores rows containing zero
col[] → Stores columns containing zero

First, traverse the matrix and mark the required rows and columns.

Then, traverse the matrix again and set the required elements to 0.

## Steps

Step 1: Find Zeroes

Traverse the complete matrix.

Whenever:

mat[i][j] == 0

mark:

row[i] = true
col[j] = true
Step 2: Set Zeroes

Traverse the matrix again.

If:

row[i] == true

or:

col[j] == true

then:

mat[i][j] = 0

## Example

Input:

1  2  3
4  0  6
7  8  9

Row markers:

row = [false, true, false]

Column markers:

col = [false, true, false]

Output:

1  0  3
0  0  0
7  0  9

## Time Complexity

O(N × M)

The matrix is traversed twice.

## Space Complexity

O(N + M)

Two additional arrays are used:

row[] → O(N)
col[] → O(M)

## Advantages

Efficient compared to brute force.
Easy to understand and implement.
Does not use a temporary marker such as -1.
Works correctly with rectangular matrices.

## Disadvantages

Requires additional memory.
Not optimal when constant extra space is required.

# Approach 3: Optimal

## Idea

The optimal approach achieves:

Time: O(N × M)
Space: O(1)

Instead of using separate row[] and col[] arrays, the first row and first column of the matrix are used as marker storage.

A separate variable col0 is used to track whether the first column itself needs to become zero.

## Why Do We Need col0?

The first column is already being used to store row information.

For example:

mat[i][0] = 0

means:

Row i needs to become zero.

Therefore, we cannot use the same location to separately remember whether the first column needs to become zero.

So we use:

col0

to store the first-column information.

## Steps

Step 1: Mark Rows and Columns

Traverse the matrix.

When a zero is found:

Mark the corresponding row using the first column.
Mark the corresponding column using the first row.
If the zero is in the first column, set col0 = 0.

Conceptually:

mat[i][0] = 0

means:

Row i → Zero

And:

mat[0][j] = 0

means:

Column j → Zero
Step 2: Process the Inner Matrix

Start from index 1 because the first row and first column contain marker information.

For every element:

if mat[i][0] == 0 || mat[0][j] == 0

set:

mat[i][j] = 0
Step 3: Process the First Row

If:

mat[0][0] == 0

set the entire first row to 0.

Step 4: Process the First Column

If:

col0 == 0

set the entire first column to 0.

## Dry Run

Input:

1  2  3  4
5  0  7  8
9  10 11 12

After marking:

1  0  3  4
0  0  7  8
9  10 11 12

The markers indicate:

Row 1 → Zero
Column 1 → Zero

After processing the inner matrix:

1  0  3  4
0  0  0  0
9  0  11 12

## Time Complexity

O(N × M)

## Space Complexity

O(1)

Only a constant amount of extra space is used.

## Advantages

Optimal time complexity.
Constant auxiliary space.
No additional row or column arrays.
Suitable for coding interviews.
Works with rectangular matrices.

## Disadvantages

More difficult to understand.
Requires careful handling of the first row and first column.
Easy to make mistakes with col0.

# Edge Cases

Empty matrix.
Matrix containing no zero.
Matrix containing only zeroes.
Zero in the first row.
Zero in the first column.
Zero at mat[0][0].
Single-row matrix.
Single-column matrix.
Rectangular matrix such as 2 × 4.
Rectangular matrix such as 4 × 2.
Multiple zeroes in the same row or column.

# Common Mistakes

Confusing the row and column dimensions.
Creating the row[] array with the wrong size.
Creating the col[] array with the wrong size.
Forgetting to handle the first row separately.
Forgetting to handle the first column separately.
Forgetting the col0 variable.
Modifying the first row or first column before using them as markers.
Starting the inner matrix traversal from index 0 instead of 1.
Using -1 as a marker when -1 can be a valid matrix value.

# Complexity Comparison

Approach	Time Complexity	Space Complexity
Brute Force	O(N × M × (N + M))	O(1)
Better	O(N × M)	O(N + M)
Optimal	O(N × M)	O(1)

# Which Approach Should You Choose?

Scenario	Recommended Approach
Simple implementation	Brute Force
Beginner-friendly	Better
Easy to understand	Better
Coding interview	Optimal
Memory optimization	Optimal
Constant extra space required	Optimal
Large matrix	Optimal

# Key Takeaways

The Brute Force approach is simple but inefficient.
The Better approach uses separate row and column arrays.
The Better approach achieves O(N × M) time with O(N + M) space.
The Optimal approach uses the first row and first column as marker storage.
The Optimal approach achieves O(N × M) time with O(1) auxiliary space.
The first column requires a separate col0 variable.
The inner matrix must be processed before modifying the first row and first column.
The optimal approach is the preferred solution for coding interviews.

# File

SetMatrixAsZero.java

# Author

Md Bakhtiyar