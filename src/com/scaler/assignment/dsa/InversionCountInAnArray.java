package com.scaler.assignment.dsa;

/*
Problem Description
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the number of inversions of A modulo (109 + 7).



Example Input
Input 1:

A = [3, 2, 1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 All pairs are inversions.
Explanation 2:

 No inversions.
 */
public class InversionCountInAnArray {

    public static void main(String[] args) {

        int[] input = new int[]{28, 18, 44, 49, 41, 14};
        System.out.println(solve(input));

    }

    public static int solve(int[] A) {

        int moduloDivisor = 1000000007;

        long[] output = new long[1];
        sort(A, 0, A.length-1,output);

        return (int)(output[0] % moduloDivisor);

    }


    public static void merge(int arr[], int l, int m, int r,long[] output)
    {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
                output[0] = output[0] + (n1-i);
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void sort(int arr[], int l, int r,long[] output)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m,output);
            sort(arr, m + 1, r,output);

            merge(arr, l, m, r,output);
        }
    }
}

/*
Solution Approach
Algorithm :
The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.
Create a function merge that counts the number of inversions when two halves of the array are merged, create two indices i and j, i is the index for the first half, and j is an index of the second half. if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
Create a recursive function to divide the array into halves and find the answer by summing the number of inversions is the first half, the number of inversion in the second half and the number of inversions by merging the two.
The base case of recursion is when there is only one element in the given half.
Print the answer
*/