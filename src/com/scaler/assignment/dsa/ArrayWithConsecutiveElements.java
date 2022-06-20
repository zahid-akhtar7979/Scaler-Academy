package com.scaler.assignment.dsa;

import java.util.Collections;
import java.util.List;

/*
Problem Description
Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return 1 if the array elements are consecutive else return 0.



Example Input
Input 1:

 A = [3, 2, 1, 4, 5]
Input 2:

 A = [1, 3, 2, 5]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 As you can see all the elements are consecutive, so we return 1.
Explanation 2:

 Element 4 is missing, so we return 0.
 */

public class ArrayWithConsecutiveElements {

    public static void main(String[] args) {

    }
    public int solve(List<Integer> A) {

        Collections.sort(A);

        for (int i = 1; i<A.size() ;i++){
            if(A.get(i) - A.get(i-1) != 1){
                return 0;
            }
        }
        return 1;
    }
}
/*
Solution Approach
We can check that if we sort the array in increasing order, the prev element should be less than the current one.

If this condition satisfies for the whole array, then we return 1 else, return 0.

NOTE: Array doesn’t need to start with 1.
 */
/*
public class Solution {
    public int solve(ArrayList < Integer > A) {
        Collections.sort(A);
        int minn = A.get(0);
        for (int x: A) {
            if (x != minn)
                return 0;
            minn++;
        }
        return 1;
    }
}
 */