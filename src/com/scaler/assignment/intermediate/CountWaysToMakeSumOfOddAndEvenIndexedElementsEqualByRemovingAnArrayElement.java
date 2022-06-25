package com.scaler.assignment.intermediate;


/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
1 <= n <= 105
-105 <= A[i] <= 105


Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input
Input 1:
A=[2, 1, 6, 4]
Input 2:

A=[1, 1, 1]


Example Output
Output 1:
1
Output 2:

3


Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.
 */
public class CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement {

    public static void main(String[] args) {

    }
    public int solve(int[] A) {

        return cntIndexesToMakeBalance(A,A.length);
    }

    public static int cntIndexesToMakeBalance(int arr[], int n)
    {
        if (n == 1)
        {
            return 1;
        }
        if (n == 2)
            return 0;
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < n; i++)
        {
            if (i % 2 == 0)
            {
                sumEven += arr[i];
            }
            else
            {
                sumOdd += arr[i];
            }
        }
        int currOdd = 0;
        int currEven = arr[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;
        for (int i = 1; i < n - 1; i++)
        {
            if (i % 2 != 0)
            {
                currOdd += arr[i];
                newEvenSum = currEven + sumOdd
                        - currOdd;

                newOddSum = currOdd + sumEven
                        - currEven - arr[i];
            }

            else
            {

                currEven += arr[i];

                newOddSum = currOdd + sumEven
                        - currEven;
                newEvenSum = currEven + sumOdd
                        - currOdd - arr[i];
            }
            if (newEvenSum == newOddSum)
            {
                res++;
            }
        }

        if (sumOdd == sumEven - arr[0])
        {

            res++;
        }

        if (n % 2 == 1)
        {
            if (sumOdd == sumEven - arr[n - 1])
            {
                res++;
            }
        }

        else
        {

            if (sumEven == sumOdd - arr[n - 1])
            {

                res++;
            }
        }

        return res;
    }

}
/*
Solution Approach
based on the observation that removing any element from the given array makes even indices of succeeding elements as odd and odd indices of the succeeding elements as even. Follow the steps below to solve the problem:

 Initialize two variables, say evenSum and oddSum,
 to store the sum of odd-indexed and even-indexed elements of the given array respectively.
Traverse the array using variable i.
Remove every ith element of the array and update the sum of the remaining even-indexed elements
and the odd-indexed elements based on the above observation. Check if the sums are equal or not.
If found to be true, then increment the count.
Finally, print the count obtained.
 */

/*
public class Solution {

    private int cntIndexesToMakeBalance(int arr[], int n)
    {
        if (n == 1) {
            return 1;
        }

        if (n == 2)
            return 0;

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumEven += arr[i];
            }
            else {
                sumOdd += arr[i];
            }
        }

        int currOdd = 0;
        int currEven = arr[0];
        int res = 0;
        int newEvenSum = 0;
        int newOddSum = 0;

        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) {
                currOdd += arr[i];
                newEvenSum = currEven + sumOdd
                             - currOdd;
                newOddSum = currOdd + sumEven
                            - currEven - arr[i];
            }
            else {
                currEven += arr[i];
                newOddSum = currOdd + sumEven
                            - currEven;
                newEvenSum = currEven + sumOdd
                             - currOdd - arr[i];
            }
            if (newEvenSum == newOddSum) {
                res++;
            }
        }
        if (sumOdd == sumEven - arr[0]) {
            res++;
        }
        if (n % 2 == 1) {
            if (sumOdd == sumEven - arr[n - 1]) {
                res++;
            }
        }
        else {
            if (sumEven == sumOdd - arr[n - 1]) {
                res++;
            }
        }
        return res;
    }

    public int solve(int[] A) {
        int n = A.length;
        return cntIndexesToMakeBalance(A, n);
    }
}
 */