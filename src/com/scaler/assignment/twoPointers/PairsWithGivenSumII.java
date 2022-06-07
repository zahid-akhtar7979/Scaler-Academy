package com.scaler.assignment.twoPointers;

import java.util.ArrayList;

/*
Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.
 */

public class PairsWithGivenSumII {
    public static void main(String[] args) {

    }
    public int solve(ArrayList<Integer> A, int B) {

        int i = 0;
        int j = A.size() - 1;
        long count = 0;

        while(i<j){

            if(A.get(i) + A.get(j) == B){
                if(A.get(i).intValue() == A.get(j).intValue()){
                    long x = j-i +1;
                    count = (count + (x*(x-1))/2) % 1000000007;
                    return (int)count;
                }
                else{
                    int k = 1;
                    int y = 1;
                    while((A.get(i).intValue() ==A.get(i+1).intValue()) && i < j){
                        k++;
                        i++;
                    }
                    while((A.get(j).intValue() == A.get(j-1).intValue()) && i<j){
                        y++;
                        j--;
                    }
                    count = (count + k*y) %  1000000007;
                }
                i++;
                j--;
            }
            else if(A.get(i) + A.get(j) > B){
                j--;
            }
            else{
                i++;
            }
        }
        return (int) (count %  1000000007) ;
    }
}
/*
Let us formulate a two pointer approach to the this problem.
We will first sort the given array and use two pointers i and j with i = 0, j = Length of Array - 1.
We will have three conditions:

1. A[i] + A[j] < sum  --> We will increase the pointer i.
2. A[i] + A[j] > sum  --> We will decrease the pointer j.
3. A[i] + A[j] = sum  --> We will count the frequency of A[i] and A[j] and multiply them and add to the answer.

Note, that if A[i] and A[j] are equal in value, then we will have to change the formula instead:
freq(A[i]) * freq(A[i])  --> freq(A[i]) * (freq(A[i]) - 1) / 2
to avoid overcounting pairs.

Refer to the complete solution for more details.
 */

/*
public class Solution {
    public int solve(int[] A, int B) {
        int i = 0, j = A.length - 1, mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
                int ii = i, jj = j;
                if (A[i] == A[j]) {
                    long cnt = j - i + 1;
                    ans += (cnt * (cnt - 1) / 2) % mod;
                    ans %= mod;
                    break;
                } else {
                    // count number of elements with value A[i]
                    while (A[i] == A[ii]) {
                        ii++;
                    }
                    int cnt1 = ii - i;
                    i = ii;

                    // count number of elements with value A[i]
                    while (A[jj] == A[j]) {
                        jj--;
                    }
                    int cnt2 = j - jj;
                    j = jj;
                    ans += (cnt1 * cnt2) % mod;
                    ans %= mod;
                }
            } else if (A[i] + A[j] > B) {
                j--;
            } else i++;
        }
        return (int) ans;
    }
}
 */
