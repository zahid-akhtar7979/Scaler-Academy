package com.scaler.assignment.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given an array of size N, find the subarray of size K with the least average.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.


Output Format
Return the index of the first element of the subarray of size k that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A=[3, 7, 90, 20, 10, 50, 40]
B=3
Input 2:

A=[3, 7, 5, 20, -10, 0, 12]
B=2


Example Output
Output 1:
3
Output 2:

4


Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average
 */

public class SubarrayWithLeastAverage {
    public static void main(String[] args) {

        System.out.println(solve(Arrays.asList(3, 7, 90, 20, 10, 50, 40),3));

    }

    public static int solve(List<Integer> A, int B) {

        List<Integer>prefixSum = new ArrayList<>();

        for(int i = 0; i<A.size(); i++){
            prefixSum.add(0);
        }

        prefixSum.set(0,A.get(0));
        for(int i = 1; i<A.size(); i++){
            prefixSum.set(i,A.get(i) + prefixSum.get(i-1));
        }
        int k =0;
        int index = 0;
        int minSubArray = prefixSum.get(B-1);
        for(int i = B; i < prefixSum.size() ; i++){
            if((prefixSum.get(i) -prefixSum.get(k)) < minSubArray){
                minSubArray = prefixSum.get(i) -prefixSum.get(k);
                index = i-B +1;
            }
            k++;
        }
        return index;

    }
}
/*
Solution Approach
An Efficient Solution is to solve the above problem in O(n) time and O(1) extra space. The idea is to use sliding window of size k. Keep track of sum of current k elements. To compute sum of current window, remove first element of previous window and add current element (last element of current window).

1) Initialize res_index = 0 // Beginning of result index
2) Find sum of first k elements. Let this sum be 'curr_sum'
3) Initialize min_sum = sum
4) Iterate from (k+1)'th to n'th element, do following
   for every element arr[i]
      a) curr_sum = curr_sum + arr[i] - arr[i-k]
      b) If curr_sum < min_sum
           res_index = (i-k+1)
5) Print res_index and res_index+k-1 as beginning and ending
   indexes of resultant subarray.

 */

/*
public class Solution {
    private int findMinAvgSubarray(int arr[], int n, int k)
    {

        // Initialize  beginning index of result
        int res_index = 0;

        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++)
            curr_sum += arr[i];

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;

        // Traverse from (k+1)'th element to n'th element
        for (int i = k; i < n; i++) {
            // Add current item and remove first item of
            // previous subarray
            curr_sum += arr[i] - arr[i - k];

            // Update result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = (i - k + 1);
            }
        }
        return res_index;
    }
    public int solve(int[] A, int B) {
        int n = A.length;
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = A[i];
        return findMinAvgSubarray(arr, n, B);
    }
}
 */