## Set Matrix Zeroes
Problem Statement

Given an n × m matrix, if any element in the matrix is 0, set its entire row and column to 0.

The matrix should be modified in-place.

Approaches

There are three common approaches to solve this problem:

## Brute Force Approach
## Better Approach
## Optimal Approach
Approach 1: Brute Force
Idea

Traverse the matrix and whenever a 0 is found:

Mark all elements in the same row.
Mark all elements in the same column.
Use -1 as a temporary marker.
After completing the traversal, convert all -1 values to 0.
Steps
Step 1

Traverse the entire matrix.

If:

mat[i][j] == 0

mark the corresponding row and column.

Step 2

Use -1 as a temporary marker so newly modified cells do not immediately affect the traversal.

Step 3

Traverse the matrix again and convert every -1 to 0.

Example

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
Time Complexity
O(N × M × (N + M))
Space Complexity
O(1)
Advantages
Simple to understand.
Easy to implement.
Does not require additional arrays.
Disadvantages
Inefficient for large matrices.
Repeatedly traverses rows and columns.
Uses -1 as a temporary marker, so it is problematic if -1 is a valid value that must be preserved.
Approach 2: Better
Idea

Use two separate boolean arrays to remember which rows and columns contain zero.

row[] → Stores rows containing zero
col[] → Stores columns containing zero

This avoids repeatedly modifying rows and columns during the first traversal.

Steps
Step 1

Traverse the matrix.

Whenever a zero is found:

row[i] = true
col[j] = true
Step 2

Traverse the matrix again.

If:

row[i] == true

or:

col[j] == true

set:

mat[i][j] = 0
Example

Input:

1  2  3
4  0  6
7  8  9

Row marker:

row = [false, true, false]

Column marker:

col = [false, true, false]

Output:

1  0  3
0  0  0
7  0  9
Time Complexity
O(N × M)
Space Complexity
O(N + M)
Advantages
Efficient.
Easy to understand.
No temporary value such as -1 is required.
Works correctly with rectangular matrices.
Disadvantages
Requires additional O(N + M) memory.
Not the optimal solution when constant extra space is required.
Approach 3: Optimal
Idea

The optimal approach avoids creating separate row[] and col[] arrays.

Instead, the first row and first column of the matrix are used as marker storage.

A separate variable col0 is used to remember whether the first column itself needs to be converted to zero.

Why Do We Need col0?

The first column is already being used to store row information.

For example:

mat[i][0] = 0

means:

Row i needs to be set to zero.

Therefore, we cannot use the same location to independently remember whether the first column needs to be zero.

So we use:

col0

to store that information.

Steps
Step 1: Mark Rows and Columns

Traverse the entire matrix.

When a zero is found:

Mark the corresponding row using the first column.
Mark the corresponding column using the first row.
If the zero is in the first column, set col0 = 0.

Conceptually:

mat[i][0] = 0

means:

Row i → Zero

and:

mat[0][j] = 0

means:

Column j → Zero
Step 2: Process Inner Matrix

Start from index 1 because the first row and first column contain marker information.

If:

mat[i][0] == 0

or:

mat[0][j] == 0

then:

mat[i][j] = 0
Step 3: Process First Row

If:

mat[0][0] == 0

set the entire first row to zero.

Step 4: Process First Column

If:

col0 == 0

set the entire first column to zero.

Dry Run

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

After processing:

1  0  3  4
0  0  0  0
9  0  11 12
Time Complexity
O(N × M)
Space Complexity
O(1)
Advantages
Optimal time complexity.
Constant auxiliary space.
No additional row or column arrays.
Suitable for coding interviews.
Works with rectangular matrices.
Disadvantages
More difficult to understand.
Requires careful handling of the first row and first column.
Easy to make mistakes with the col0 variable.
Edge Cases
Empty matrix.
Matrix containing no zero.
Matrix containing only zeroes.
Zero in the first row.
Zero in the first column.
Zero at mat[0][0].
Single-row matrix.
Single-column matrix.
Rectangular matrix such as 2 × 4 or 4 × 2.
Multiple zeroes in the same row or column.
Common Mistakes
Confusing row and column dimensions.
Using boolean row[] = new boolean[m] instead of new boolean[n].
Using boolean col[] = new boolean[n] instead of new boolean[m].
Forgetting to handle the first row separately.
Forgetting to handle the first column separately.
Not using a separate col0 variable.
Processing the first row and first column too early and destroying marker information.
Starting the inner traversal from index 0 instead of 1.
Complexity Comparison
Approach	Time	Space
Brute Force	O(N × M × (N + M))	O(1)
Better	O(N × M)	O(N + M)
Optimal	O(N × M)	O(1)
Which Approach Should You Choose?
Scenario	Recommended Approach
Easy implementation	Better
Beginner-friendly	Better
Understanding the basic concept	Brute Force
Coding interview	Optimal
Memory optimization	Optimal
Constant extra space required	Optimal
Large matrix	Optimal
Key Takeaways
The Brute Force approach is simple but inefficient.
The Better approach achieves O(N × M) time using O(N + M) extra space.
The Optimal approach achieves O(N × M) time with O(1) auxiliary space.
The first row and first column can be reused as marker storage.
The first column requires a separate col0 variable.
The optimal solution must process the inner matrix before modifying the first row and first column.
Author

## Md Bakhtiyar