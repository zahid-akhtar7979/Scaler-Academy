package com.scaler.assignment.binarySearch;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

Constraints are satisfied for maximal value of 2.
Explanation 2:

Constraints are satisfied for maximal value of 3.
 */

public class SpecialInteger {

    public static void main(String[] args) {

        System.out.println(solve(Arrays.asList(1, 1000000000),1000000000));
        System.out.println(hasSubArrayWithGreaterSum(Arrays.asList(1, 2, 3, 4, 5),10,3));

    }

    public static int solve(List<Integer> A, int B) {

        int ans = 0;

        int start = 1;
        int end = A.size();

        while(start <= end){

            int mid = (start + end)/2;
            if(hasSubArrayWithGreaterSum( A, B, mid) ){
                ans = mid;
                start = mid +1;
            }
            else  {
               end = mid-1;
            }
        }

        return ans;

    }

    public static boolean hasSubArrayWithGreaterSum(List<Integer> A, int B, int k){

        int sum = 0;
        int i = 0 ;
        int j = 0;

        while (i < A.size()){

            while(i < k ){
                sum = sum + A.get(i);
                if(sum >= B) {
                    return false;
                }
                i++;
            }

            if(i < A.size()){
                sum = sum + A.get(i) - A.get(j);

                if(sum > B){
                    return false;
                }
                j++;
                i++;
            }

        }
        return true;
    }
}
/*
Solution Approach
You need to find the maximal K.
Think of a way to do this by binary search.
You can use binary seacrh to find if a certain K is allowed or not.
if it is, you try finding a bigger answer
if not, try finding a smaller answer.
int l = 1, r = a.length;
while(l <= r) {
int m = (l + r) » 1;
if(check(a, b, m)) l = m + 1;
else r = m - 1;
}
return l-1;
 */

/*
public class Solution {
   public int solve(int[] A, int B) {

      long[] prefix = new long[A.length];
      for (int i = 0; i < A.length; ++i) {
         prefix[i] = A[i];
      }

      //calculating the prefix sum;
      for (int i = 1; i < A.length; ++i)
         prefix[i] += prefix[i - 1];

      //Binary search for the for the length
      int lo = 1;
      int hi = A.length, ans = 0;
      while (lo <= hi) {
         int mid = (hi - lo) / 2 + lo; // to keep our mid towards the right
         if (check(mid, prefix, (long) B) == 1) {
            hi = mid - 1;
         } else {
            ans = mid;
            lo = mid + 1;
         }
      }
      return ans;

   }

   //tells if there is a subarray of size s
   //whose sum is greater than sm in linear time;
   int check(int s, long[] arr, long sm) {
      int flag = 0;
      for (int i = s - 1; i < arr.length; ++i) {
         if (i == s - 1) {
            if (arr[i] > sm)
               return 1;
         } else if (arr[i] - arr[i - s] > sm) {
            return 1;
         }
      }
      return 0;
   }
}
 */