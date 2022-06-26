package com.scaler.assignment.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description

You are given an integer array A having N integers.

You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.



Problem Constraints

1 <= N <= 105

-109 <= A[i] <= 109



Input Format

First and only argument is an integer array A.



Output Format

Return an integer denoting the minimum length.



Example Input

Input 1:

 A = [0, 1, 15, 25, 6, 7, 30, 40, 50]
Input 2:

 A = [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60]


Example Output

Output 1:

 4
Output 2:

 6


Example Explanation

Explanation 1:

 The smallest subarray to be sorted to make the whole array sorted =  A[3..6] i.e, subarray lying between positions 3 and 6.
Explanation 2:

 The smallest subarray to be sorted to make the whole array sorted =  A[4..9] i.e, subarray lying between positions 4 and 9.
 */

public class SortTheUnsortedArray {

    public static void main(String[] args) {

        System.out.println(solve(Arrays.asList(-355071087, -679308132, 398052175, 755454983, 814022370, 889267058)));

    }
    public static int solve(List<Integer> A) {

        List<Integer>list = new ArrayList<>(A);
        Collections.sort(list);

        int i = 0;
        int j =A.size()-1;

        int firstMisMatch = -1;
        int lastMisMatch = -1;

       while(i < j){

           if(A.get(i).intValue() == list.get(i).intValue() ){
               i++;
           }
           else if(firstMisMatch == -1) {
               firstMisMatch = i;
           }
           if(A.get(j).intValue() == list.get(j).intValue()){
               j--;
           }
           else if (lastMisMatch == -1){
               lastMisMatch = j;
           }
           if (lastMisMatch != -1 && firstMisMatch != -1){
               break;
           }
       }
        return lastMisMatch - firstMisMatch  > 0 ? lastMisMatch - firstMisMatch + 1 : 0;
    }

}

/*
Solution Approach
ALGORITHM:
1) Find the candidate unsorted subarray
a) Scan from left to right and find the first element which is greater than the next element. Let l be the index of such an element.
b) Scan from right to left and find the first element (first in right to left order) which is smaller than the next element (next in right to left order). Let r be the index of such an element.

2) Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then include more elements in the subarray.
a) Find the minimum and maximum values in arr[l..r]. Let minimum and maximum values be min and max.
b) Find the first element (if there is any) in arr[0..l-1] which is greater than min, change l to index of this element.
c) Find the last element (if there is any) in arr[r+1..N-1] which is smaller than max, change r to index of this element.

3) The subarray A[l..r] is the solution subarray. Hence, the length returned is r - l + 1.
 */

/*
public class Solution {
    public int solve(int[] A) {
        int N = A.length;

        int l = 0;
        int r = N - 1;

        for (l = 0; l < N - 1; l++)
        {
            if (A[l] > A[l + 1])
                break;
        }

        if (l == N - 1){
            return 0;
        }


        for(r = N - 1; r > 0; r--)
        {
            if(A[r] < A[r - 1])
                break;
        }


        int mx = A[l];
        int mn = A[l];

        for(int i = l + 1; i <= r; i++)
        {
            if(A[i] > mx)
                mx = A[i];
            if(A[i] < mn)
                mn = A[i];
        }


        for(int i = 0; i < l; i++)
        {
            if(A[i] > mn)
            {
                l = i;
                break;
            }
        }

        for(int i = N - 1; i >= r + 1; i--)
        {
            if(A[i] < mx)
            {
                r = i;
                break;
            }
        }

        return r - l + 1;
    }
}
 */