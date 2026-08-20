**# Pascal's Triangle**

**## Problem Statement**

Given an integer `n`, generate **Pascal's Triangle** containing `n` rows.

Pascal's Triangle follows these rules:

* Every row starts and ends with `1`.
* Each inner element is the sum of the two elements directly above it.
* The value at position `(n, r)` can also be calculated using the binomial coefficient.

```text
C(n, r) = n! / (r! × (n-r)!)
```

This implementation covers three common Pascal's Triangle problems:

1. **Find a Single Element**
2. **Generate a Specific Row**
3. **Generate the Entire Pascal's Triangle**

---

**# Pascal's Triangle Example**

For `n = 5`:

```text
        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1
```

As a list:

```text
[
    [1],
    [1, 1],
    [1, 2, 1],
    [1, 3, 3, 1],
    [1, 4, 6, 4, 1]
]
```

---

**# Approaches**

There are three common problems implemented in this project:

1. **Find a Single Element**
2. **Generate a Specific Row**
3. **Generate the Entire Pascal's Triangle**

---

**# Approach 1: Find a Single Element**

**## Idea**

To find an element at position `(n, r)`, use the binomial coefficient:

```text
C(n, r)
```

Instead of calculating factorials directly, the code calculates the result iteratively:

```text
C(n, r) = C(n, r-1) × (n-r+1) / r
```

This avoids calculating the complete factorial values.

---

**## Example**

For:

```text
n = 4
r = 2
```

The result is:

```text
C(4, 2) = 6
```

Pascal's Triangle row `4` is:

```text
1 4 6 4 1
```

The element at index `2` is:

```text
6
```

---

**## Time Complexity**

```text
O(r)
```

---

**## Space Complexity**

```text
O(1)
```

---

**## Advantages**

* Simple iterative calculation.
* Does not require generating the complete triangle.
* Uses constant auxiliary space.

---

**## Disadvantages**

* `int` can overflow for large values.
* Only calculates one element.

---

**# Approach 2: Generate a Specific Row**

**## Idea**

To generate a complete row, start with `1` and calculate each next element using the previous element.

The formula used is:

```text
C(n, col) = C(n, col-1) × (n-col+1) / col
```

This avoids calculating factorials for every element.

---

**## Example**

For:

```text
row = 4
```

The generated row is:

```text
[1, 4, 6, 4, 1]
```

---

**## Algorithm**

1. Create an empty list.
2. Add `1` as the first element.
3. Initialize `ans = 1`.
4. Iterate through the remaining columns.
5. Calculate the next element using the previous value.
6. Add each calculated value to the result list.
7. Return the completed row.

---

**## Time Complexity**

```text
O(n)
```

---

**## Space Complexity**

```text
O(n)
```

The `O(n)` space is required to store the resulting row.

---

**## Advantages**

* Efficient row generation.
* Avoids factorial calculations.
* Easy to implement.
* Uses the previous element to calculate the next element.

---

**## Disadvantages**

* Uses `O(n)` space to store the row.
* `int` can overflow for sufficiently large values.

---

**# Approach 3: Generate Entire Pascal's Triangle**

**## Idea**

Use the row-generation helper method to generate every row.

For every row from `0` to `n - 1`:

```text
getTriangleHelper(i)
```

generates that row and adds it to the final result.

---

**## Algorithm**

1. Create a list to store all rows.
2. Iterate from `0` to `n - 1`.
3. Generate each row using `getTriangleHelper()`.
4. Add the generated row to the triangle.
5. Return the complete triangle.

---

**## Example**

For:

```text
n = 5
```

The result is:

```text
[
    [1],
    [1, 1],
    [1, 2, 1],
    [1, 3, 3, 1],
    [1, 4, 6, 4, 1]
]
```

---

**## Time Complexity**

```text
O(n²)
```

---

**## Space Complexity**

```text
O(n²)
```

The returned triangle itself contains `O(n²)` elements.

---

**## Advantages**

* Generates the complete Pascal's Triangle efficiently.
* Reuses the helper method for row generation.
* Avoids repeated factorial calculations.
* Simple and modular implementation.

---

**## Disadvantages**

* Requires `O(n²)` space because the complete triangle must be stored.
* `int` can overflow for large values.

---

**# Important Formula**

The implementation uses the following relationship:

```text
C(n, r) = C(n, r-1) × (n-r+1) / r
```

For example, for row `4`:

```text
C(4,0) = 1

C(4,1) = 1 × 4 / 1 = 4

C(4,2) = 4 × 3 / 2 = 6

C(4,3) = 6 × 2 / 3 = 4

C(4,4) = 4 × 1 / 4 = 1
```

Result:

```text
1 4 6 4 1
```

---

**# Complexity Comparison**

| Method                   | Purpose                  | Time Complexity | Space Complexity |
| ------------------------ | ------------------------ | --------------: | ---------------: |
| `getSingleElement(n, r)` | Find one element         |          `O(r)` |           `O(1)` |
| `getTriangleHelper(row)` | Generate one row         |        `O(row)` |         `O(row)` |
| `getTringle(n)`          | Generate entire triangle |         `O(n²)` |          `O(n²)` |

---

**# Complexity Analysis**

**## Single Element**

Only `r` iterations are required:

```text
Time: O(r)
Space: O(1)
```

---

**## Specific Row**

A row contains `n + 1` elements:

```text
Time: O(n)
Space: O(n)
```

The space is required to store the resulting row.

---

**## Entire Triangle**

The triangle contains:

```text
1 + 2 + 3 + ... + n
```

elements.

Therefore:

```text
n(n + 1) / 2
```

elements are generated.

Hence:

```text
Time: O(n²)
Space: O(n²)
```

---

**# Code Structure**

```text
Pascal.java
│
├── getSingleElement()
│   └── Finds a single Pascal Triangle element
│
├── getRow()
│   └── Generates a specific row
│
├── getTriangleHelper()
│   └── Generates one complete row
│
└── getTringle()
    └── Generates the complete Pascal Triangle
```

---

**# Edge Cases**

* `n = 0`
* `n = 1`
* Single element triangle.
* First row.
* First element of a row.
* Last element of a row.
* Large values of `n`.
* Large values of `n` and `r`.

For:

```text
n = 1
```

Output:

```text
[[1]]
```

For:

```text
n = 0
```

Output:

```text
[]
```

---

**# Important Notes**

**## 1. Zero-Based Row Indexing**

The implementation uses **0-based indexing** for rows.

```text
row 0 → [1]

row 1 → [1, 1]

row 2 → [1, 2, 1]

row 3 → [1, 3, 3, 1]

row 4 → [1, 4, 6, 4, 1]
```

Therefore:

```text
getTriangleHelper(4)
```

returns:

```text
[1, 4, 6, 4, 1]
```

---

**## 2. Integer Overflow**

The implementation uses Java `int`.

For sufficiently large values of `n` and `r`, the result can exceed the range of `int` and produce overflow.

For larger constraints, `long` or `BigInteger` may be required.

---

**## 3. Method Naming**

The method:

```text
getTringle()
```

works correctly, but `Tringle` is a spelling mistake.

A cleaner method name would be:

```text
getTriangle()
```

---

**# Common Mistakes**

* Using incorrect row indexing.
* Confusing `n` and `r`.
* Using factorials unnecessarily.
* Forgetting that this implementation uses zero-based row indexing.
* Using `int` for values that exceed its range.
* Confusing generating one row with generating the complete triangle.
* Incorrectly calculating the binomial coefficient formula.

---

**# Learning**

This implementation helps understand:

* Pascal's Triangle.
* Binomial coefficients.
* `nCr` calculation.
* Mathematical formulas in programming.
* Java `ArrayList`.
* Nested loops.
* Iterative computation.
* Helper methods.
* Time and space complexity analysis.

---

**# Which Approach Should You Choose?**

| Scenario                    | Recommended Approach  |
| --------------------------- | --------------------- |
| Find one element            | `getSingleElement()`  |
| Generate one row            | `getTriangleHelper()` |
| Generate complete triangle  | `getTringle()`        |
| Constant auxiliary space    | `getSingleElement()`  |
| Avoid factorial calculation | Iterative `nCr`       |
| Complete Pascal's Triangle  | `getTringle()`        |

---

**# Key Takeaways**

* Pascal's Triangle can be calculated using the **binomial coefficient**.
* A single element can be found without generating the entire triangle.
* A complete row can be generated using the previous element.
* The entire triangle can be generated by repeatedly generating individual rows.
* The iterative `nCr` formula is more efficient than calculating factorials repeatedly.
* Generating the complete triangle requires `O(n²)` time because the triangle itself contains `O(n²)` elements.
* The implementation uses **0-based row indexing**.

---

**# Author**

**Md Bakhtiyar**
