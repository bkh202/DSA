Next Permutation Algorithm
📋 Problem Statement
Implement the next permutation algorithm that rearranges numbers into the lexicographically next greater permutation of numbers. If such arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

📊 Example
Input: [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]

Explanation:
Pivot found at index 2 (value 1)

Successor found at index 4 (value 5)

Swap 1 and 5: [2, 4, 5, 7, 1, 0]

Reverse suffix from index 3: [2, 4, 5, 0, 1, 7]

🚀 Approach
Step 1: Find the Pivot
Traverse the array from right to left to find the first index where arr[i] < arr[i+1]. This identifies the point where the sequence stops being strictly decreasing from the right.

Step 2: Handle Edge Case
If no pivot is found (the array is in descending order), reverse the entire array to get the first permutation.

Step 3: Find the Successor
Traverse from right to left to find the first element that is greater than the pivot element. This will be the smallest element that can replace the pivot to get the next greater permutation.

Step 4: Swap
Swap the pivot with its successor found in the previous step.

Step 5: Reverse the Suffix
Reverse the portion of the array after the pivot to get the smallest possible arrangement of the remaining elements.

🧠 Algorithm Used
Two-Pointer Technique & In-place Swapping

The algorithm uses:

Right-to-Left Scanning: To find the pivot and successor

Two-Pointer Swapping: To efficiently reverse array segments

In-place Transformation: Modifies the array without using extra space

Single Pass: O(n) time complexity with multiple traversals

⏱️ Complexity Analysis
Metric	Complexity
Time Complexity	O(n) - Where n is the length of the array. The algorithm makes at most three passes through the array: finding pivot, finding successor, and reversing.
Space Complexity	O(1) - The algorithm uses only constant extra space regardless of input size. All operations are performed in-place.
Worst Case	O(n) - When the array is in descending order, we need to reverse the entire array.
Best Case	O(n) - We still need to traverse the array to find the pivot, even if it's near the end.
Average Case	O(n) - Typically requires traversing about half the array.
🔑 Key Concepts
Lexicographic Ordering: The algorithm finds the next permutation in dictionary order

In-place Algorithm: No extra space required for computation

Edge Case Handling: Works for arrays in descending order (last permutation)

Stable Operation: Maintains relative order when appropriate

🎯 Core Operations
Find Breaking Point: Locate where ascending order breaks from right to left

Find Replacement: Identify the smallest larger element to the right

Swap Elements: Exchange pivot with its successor

Reverse Suffix: Reorder remaining elements in ascending order

💡 Key Insights
The pivot is always the first element from the right that is smaller than its right neighbor

The successor is always the rightmost element that is greater than the pivot

After swapping, the suffix must be reversed to get the smallest possible arrangement

When no pivot exists, the array is at its maximum lexicographic order

📝 Important Notes
This algorithm implements lexicographic ordering of permutations

It's the standard algorithm used in many programming language libraries

Works for arrays with duplicate elements as well

The algorithm handles the transition from the last permutation to the first permutation

🔄 Related Concepts
Permutations

Lexicographic Order

Next Greater Element

Previous Permutation

Generating All Permutations