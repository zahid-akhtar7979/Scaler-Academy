package com.scaler.assignment.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4, and array A contains 10 elements, then

You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you picked.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output
Output 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
 */

public class PickFromBothSides {

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(-969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517,
                807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249,
                -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587), 81));
    }

    public static int solve(List<Integer> A, int B) {

        ArrayList<Integer> leftPrefixSum = new ArrayList<>(B);
        ArrayList<Integer> rightPrefixSum = new ArrayList<>(B);

        for (int i = 0 ;i <A.size() ;i++){
            leftPrefixSum.add(0);
            rightPrefixSum.add(0);
        }

        leftPrefixSum.set(0,A.get(0));
        for (int i = 1; i<A.size() ;i++){
            leftPrefixSum.set(i,leftPrefixSum.get(i-1) + A.get(i));
        }

        System.out.println(leftPrefixSum);

        rightPrefixSum.set(A.size()-1,A.get(A.size()-1));
        for (int i = A.size()-2; i>=0 ;i--){
            rightPrefixSum.set(i,rightPrefixSum.get(i+1) + A.get(i));
        }

        System.out.println(rightPrefixSum);

        int maxSum = Integer.MIN_VALUE;
        for(int k = 0; k<=B; k++){

            if(k == 0){
                maxSum = Math.max(maxSum,rightPrefixSum.get(A.size()-B));
            } else if (k == B) {
                maxSum = Math.max(maxSum,leftPrefixSum.get(B-1));
            }
            else{
                maxSum = Math.max(maxSum,leftPrefixSum.get(k-1) + rightPrefixSum.get(A.size()-B +k));
            }
        }
        return  maxSum;
    }
}
/*
Solution Approach
Approach using Prefix and Suffix Sums:

Maintain two arrays prefix[i] and suffix[i] where prefix[i] denotes sum of elements from index [0,i] and suffix[i] denotes sum of elements from index [i,N-1].

Now iterate from left and one by one pick elements from left for example: if you pick ‘a’ elements from left and remaining ‘k-a’ elements from right.
So the sum in this case will be prefix[a-1] + suffix[n-(k-a)]

Maintain the maximum among all and return it.

Time Complexity: O(N)
Space Complexity: O(N)

where N is number of elements in array A

Bonus: Try solving it in O(1) space.
 */

/*
public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int []suff = new int[n + 1];
        suff[n] = 0;
        suff[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suff[i] = A[i] + suff[i + 1];
        }
        int pref_sum = 0;
        int ans = suff[n - B];
        for(int i = 0; i < B; i++){
            pref_sum = pref_sum + A[i];
            int suff_sum = suff[n - B + (i + 1)];
            ans = Math.max(ans, pref_sum + suff_sum);
        }
        return ans;
    }
}
 */