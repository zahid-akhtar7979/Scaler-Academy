package com.scaler.assignment.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.



Problem Constraints
1 <= N <= 10000

1<= A[i] <=1000



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the output.



Example Input
Input 1:

A = [1, 2]
Input 2:

A = [1]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

All possible non-empty subsets are:
[1]    largest-smallest = 1 - 1 = 0
[2]    largest-smallest = 2 - 2 = 0
[1 2]  largest-smallest = 2 - 1 = 1
Sum of the differences = 0 + 0 + 1 = 1
So, the resultant number is 1
Explanation 2:

 Only 1 subsequence of 1 element is formed.
 */

public class SumTheDifference {
    public static void main(String[] args) {


        System.out.println(Math.pow(2,132));
        long pow = (long) Math.pow(2,132);

        System.out.println(pow);

        System.out.println(solve(Arrays.asList(2, 7, 6, 8, 9, 6, 10, 3, 8, 4, 7, 5, 8, 10, 8, 3, 3, 2, 7, 4, 1, 3, 2, 6, 7, 6, 1, 1, 4, 5, 7, 7, 1, 3, 6, 9, 10, 6, 1, 7, 1, 9, 4, 8, 9, 3, 2, 1, 6, 9, 6, 6, 1, 8, 4, 9, 3, 4, 1, 8, 8, 8, 7, 10, 2, 2, 10, 1, 9, 10, 9, 9, 1, 4, 8, 1, 7, 10, 3, 2, 8, 8, 10, 8, 7, 3, 8, 2, 6, 9, 9, 5, 6, 7, 6, 7, 9, 5, 9, 9, 4, 9, 8, 6, 3, 5, 6, 1, 6, 8, 4, 3, 8, 3, 2, 4, 5, 10, 5, 2, 10, 6, 8, 5, 2, 3, 3, 2, 7, 3, 1, 3, 3, 10, 8, 5, 4, 6, 7, 2, 5, 1, 4, 2, 3, 8, 8, 10, 9, 2, 1, 8, 7, 1, 2, 1, 3, 6, 2, 10, 8, 2, 4, 2, 3, 1, 7, 9, 8, 5, 10, 3, 5, 5, 6, 10, 2, 3, 9, 10, 7, 1, 7, 5, 1, 10, 5, 6, 5, 7, 7, 4, 10, 10, 6, 3, 2, 4, 1, 10, 10, 2, 4, 5, 6, 9, 6, 8, 4, 4, 9, 10, 6, 6, 4, 9, 7, 1, 4, 4, 7, 2, 9, 8, 1, 6, 2, 2, 1, 4, 1, 1, 5, 6, 5, 3, 5, 10, 10, 10, 5, 10, 9, 2, 7, 4, 10, 4, 4, 5, 7, 2, 6, 7, 2, 8, 3, 3, 10, 3, 9, 2, 3, 5, 8, 9, 7, 4, 8, 8, 3, 4, 8, 3, 6, 4, 8, 7, 9, 2, 4, 7, 5, 1, 4, 6, 9, 6, 1, 10, 10, 9, 1, 3, 5, 10, 1, 2, 3, 1, 1, 7, 4, 10, 1, 9, 4, 9, 8, 4, 2, 1, 1, 6, 1, 4, 2, 9, 1, 2, 8, 10, 2, 1, 4, 6, 10, 5, 9, 5, 7, 10, 3, 10, 1, 4, 1, 4, 4, 8, 10, 5, 10, 10, 2, 10, 5, 3, 1, 7, 6, 10, 6, 7, 2, 2, 5, 4, 8, 3, 8, 4, 4, 10, 3, 5, 5, 5, 10, 10, 4, 9, 4, 3, 10, 6, 5, 4, 10, 5, 10, 6, 6, 8, 4, 10, 1, 8, 3, 8, 3, 10, 1, 6, 1, 5, 2, 8, 10, 4, 7, 3, 2, 3, 6, 4, 10, 2, 9, 9, 8, 1, 6, 3, 8, 10, 2, 10, 7, 4, 7, 9, 5, 7, 7, 8, 3, 8, 5, 2, 1, 1, 7, 5, 5, 4, 8, 4, 5, 8, 3, 2, 8, 10, 6, 7, 9, 10, 6, 6, 3, 2, 6, 10, 10, 2, 7, 3, 2, 1, 6, 4, 3, 2, 10, 8, 7, 9, 3, 1, 7, 5, 4, 4, 7, 10, 1, 5, 9, 6, 2, 3, 10, 8, 4, 9, 1, 10, 3, 4, 2, 9, 8, 5, 2, 7, 4, 9, 6, 6, 1, 2, 3, 7, 5, 9, 6, 7, 3, 6, 3, 7, 10, 2, 4, 4, 2, 6, 3, 7, 10, 5, 5, 7, 1, 8, 5, 4, 8, 10, 1, 1, 3, 3, 7, 10, 1, 4, 6, 6, 9, 8, 2, 8, 1, 7, 1, 5, 2, 4, 1, 3, 10, 7, 1, 10, 4, 6, 5, 4, 7, 5, 4, 2, 10, 2, 1, 10, 5, 6, 7, 3, 6, 10, 2, 8, 8, 5, 2, 2, 10, 2, 4, 9, 8, 5, 10, 4, 2, 4, 9, 8, 10, 4, 9, 9, 5, 1, 1, 9, 7, 9, 3, 4, 9, 6, 1, 6, 10, 3, 7, 9, 6, 3, 9, 4, 7, 8, 9, 8, 3, 7, 7, 3, 10, 8, 1, 4, 8, 3, 4, 6, 2, 8 )));
    }
    public static int solve(List<Integer> A) {


        Collections.sort(A);

        int modularDiv = 1000000007;

        double firstSum = 0;
        double lastSum = 0;

        int n = A.size();

        for (int i = 0; i < n; i++){
            firstSum += (A.get(i) * (Math.pow(2, n - i - 1) % modularDiv)) % modularDiv ;
            firstSum %= modularDiv;
        }
        for (int i = 0; i < n; i++){
            lastSum +=  (A.get(i) * (Math.pow(2, i) % modularDiv)) % modularDiv;
        }

        return  (int)(((lastSum  - firstSum) % modularDiv));
    }

    public static long power(int x, int y)
    {
        long temp;
        if( y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }
}

/*
Solution Approach
It can be seen that if elements are sorted, then taking any two indexes,
there will be a fixed number of K elements in between then.
So you can take any number of K elements that are in between those two elements.
So the difference of the values of those two indexes will contribute 2 to the power of K (subsets) to the answer.
So we will take all possible pairs of elements.

Example:
1 2 3 4
If we take indexes 0 and 3, i.e., elements 1 and 4. There are two elements between them (2, 3).
So 1 and 4 are in 4 subsets which are
a) 1 4
b) 1 2 4
c) 1 3 4
d) 1 2 3 4
Which is 2 to the power of 2.
The complexity if O(N^2)

If we take a close look at the approach above,
we can solve it in O(N) also.
After sorting the array,
Answer is {A[N-1]2^(N-1) +A[N-2]2^(N-2) +…..+A[0]2^0} - {A[0]2^(N-1) + A[1]2^(N-2) +……+ A[0]2^0}
 */

/*
public class Solution {
    public int solve(ArrayList < Integer > A) {
        Collections.sort(A);
        int Mod = 1000 * 1000 * 1000 + 7;
        long minus = 0, plus = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            minus += (val * pow(2, A.size() - 1 - i, Mod)) % Mod;
            minus %= Mod;
            plus += (val * pow(2, i, Mod)) % Mod;
            plus %= Mod;
        }
        return (int)((plus - minus + Mod) % Mod);
    }
    public long pow(long x, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
}
 */