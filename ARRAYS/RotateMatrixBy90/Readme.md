# Rotate Matrix by 90 Degrees

**Author:** Md Baktiyar

This repository contains Java implementations for rotating an $N \times N$ 2D matrix by 90 degrees. It includes both clockwise and anti-clockwise rotations using optimal in-place algorithms.

## 1. Rotate Clockwise (Brute Force)
Creates a new matrix and maps the elements to their rotated positions. 
*   **Approach:** Allocate a new $N \times N$ matrix. Traverse the original matrix and place the element at `mat[i][j]` into the new matrix at `temp[j][N - 1 - i]`. 
*   **Time Complexity (TC):** $O(N^2)$ - Iterates through all elements of the $N \times N$ matrix.
*   **Space Complexity (SC):** $O(N^2)$ - Requires allocating a new 2D array of the same size.

## 2. Rotate Clockwise (Optimal In-Place)
Rotates the matrix by 90 degrees to the right without using extra space.
*   **Approach:** A two-step mathematical process:
    1. **Transpose the matrix:** Swap `mat[i][j]` with `mat[j][i]`. This turns rows into columns.
    2. **Reverse each row:** Swap the left and right elements of every row using two pointers until they meet in the middle.
*   **Time Complexity (TC):** $O(N^2)$ - $O(N^2)$ for the transpose step and $O(N^2)$ for reversing the rows.
*   **Space Complexity (SC):** $O(1)$ - The transformation is done strictly in-place.

## 3. Rotate Anti-Clockwise (Optimal In-Place)
Rotates the matrix by 90 degrees to the left without using extra space.
*   **Approach:** A two-step mathematical process:
    1. **Transpose the matrix:** Swap `mat[i][j]` with `mat[j][i]`. 
    2. **Reverse each column:** Swap the top and bottom elements of every column using two pointers until they meet in the middle. (This is the key difference from the clockwise approach).
*   **Time Complexity (TC):** $O(N^2)$ - $O(N^2)$ for the transpose step and $O(N^2)$ for reversing the columns.
*   **Space Complexity (SC):** $O(1)$ - The transformation is done strictly in-place.