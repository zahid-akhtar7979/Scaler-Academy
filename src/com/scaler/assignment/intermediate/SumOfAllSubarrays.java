package com.scaler.assignment.intermediate;

import java.util.ArrayList;

/*
Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.



Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4


Input Format
The first argument is the integer array A.


Output Format
Return a single integer denoting the sum of all subarray sums of the given array.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:

A = [2, 1, 3]


Example Output
Output 1:
20
Output 2:

19


Example Explanation
Explanation 1:
The different subarrays for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20
Explanation 2:

Similiar to the first example, the sum of all subarray sums for this array is 19.

 */

public class SumOfAllSubarrays {

    public static void main(String[] args) {

    }

    public Long subarraySum(ArrayList<Integer> A) {

        long subarraySum = 0l;
        for(int i = 0;i < A.size(); i++){
            subarraySum +=  (long)A.get(i)*(A.size()-i)*(i+1);

        }
        return subarraySum;
    }
}
/*
Solution Approach
For each element, if we know how many subarrays do they come in,
we can easily calculate their contribution to the sum as (Number of Subarrays) * (A[i]).

How do we calculate the number of subarrays for each element?
Let us focus on the definition of a subarray. It is obtained by deleting zero or more elements from either end.
So, for each element, let X be the number of elements to their left, and Y be the number of elements to their right.
Number of required subarrays = (X + 1) * (Y + 1)

We can easily know X and Y from the index of the element.
Let the array be 0 - indexed and N be the length of the array,
X = i, Y = N - i - 1

Refer to the complete solution for implementation details.
 */

/*
class Solution {
    public long subarraySum(int[] A) {
        long ans = 0;
        int n = A.length;
        for (int i = 0; i < n; i++)
            ans += (long)A[i] * (i + 1) * (n - i);
        return ans ;
    }
}
 */