package com.scaler.assignment.intermediate.BasicMaths;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description
Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.



Problem Constraints
2 <= length of the array <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum value of | A[i] - A[j] |.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 The absolute difference between any two adjacent elements is 1, which is the minimum value.
Explanation 2:

 The minimum value is 6 (|11 - 5| or |17 - 11|).
 */

public class MinimumAbsoluteDifference {

    public static void main(String[] args) {

        System.out.println(solve(Arrays.asList(5, 17, 100, 11)));
    }

    public static int solve(List<Integer> A) {

        int minValue = Integer.MAX_VALUE;
        Collections.sort(A);

        for (int i = 0; i<A.size()-1 ;i++){
            minValue = Math.min(minValue, Math.abs(A.get(i+1) - A.get(i)));
        }
        return minValue;
    }
}
/*
Solution Approach
Sort the array.

We can observe that the answer will be the minimum value of absolute difference between the adjacent elements.

We can iterate over the sorted array and maintain the minimum value of absolute difference.

Return the answer.
 */

/*
public class Solution {
    public int solve(ArrayList < Integer > A) {
        int n = A.size();
        // Sort the array
        Collections.sort(A);
        // Initialize the ans variable
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // Store the minimum value
            ans = Math.min(ans, A.get(i) - A.get(i - 1));
        }
        return ans;
    }
}
 */