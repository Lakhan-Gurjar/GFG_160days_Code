/*
Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange 
the numbers into the lowest possible order (i.e., sorted in ascending order). 

Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

Examples:

Input: arr = [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]
Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.

Input: arr = [3, 2, 1]
Output: [1, 2, 3]
Explanation: As arr[] is the last permutation, the next permutation is the lowest one.

Input: arr = [3, 4, 2, 5, 1]
Output: [3, 4, 5, 1, 2]
Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
*/
// I guessed out the brute force approach but could not get intiution for optimal solution so I watched Striver's Video : https://www.youtube.com/watch?v=JDOXKqF60RQ
// I code it myself but there were some mistakes which are taken care by chatgpt with explanation
class Solution {
    void nextPermutation(int[] arr) {
    int n = arr.length;
    
    // Step 1: Find the break-point
    int ind = -1; // break-point
    
    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] < arr[i + 1]) {
            ind = i;
            break;
        }
    }
    
    // Step 2: If no break-point is found, reverse the whole array
    if (ind == -1) {
        reverseArray(arr, 0, n - 1);
        return;
    }
    
    // Step 3: Find the next greater element on the right of the break-point and swap
    for (int i = n - 1; i > ind; i--) {
        if (arr[i] > arr[ind]) {
            int temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
            break;
        }
    }
    
    // Step 4: Reverse the right part from ind + 1 to the end of the array
    reverseArray(arr, ind + 1, n - 1);
}

// Helper function to reverse the array between two indices
void reverseArray(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

}
