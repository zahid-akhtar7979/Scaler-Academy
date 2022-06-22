package com.scaler.assignment.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Problem Description
Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that

a1 >= a2 <= a3 >= a4 <= a5.....
NOTE: If multiple answers are possible, return the lexicographically smallest one.



Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106



Input Format
The first argument is an integer array A.



Output Format
Return an array arranged in the sequence as described.



Example Input
Input 1:

A = [1, 2, 3, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1, 4, 3]
Output 2:

[2, 1]


Example Explanation
Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].
Explanation 1:

Only possible answer is [2, 1].
 */

public class WaveArray {

    public static void main(String[] args) {

        System.out.println(wave(Arrays.asList(1, 2, 3, 4)));

    }

    public static List<Integer> wave(List<Integer> A) {

        Collections.sort(A);

        for(int i = 0 ;i <A.size()-1 ;i+=2){
            Collections.swap(A,i,i+1);
        }
        return A;
    }
}

/*
Solution Approach
Let’s take an example:

array = {5, 1, 3, 4, 2}

Sort the above array.

array = {1, 2, 3, 4, 5}

Now swap adjacent elements in pairs.

swap(1, 2)
swap(3, 4)

Now, our array = {2, 1, 4, 3, 5}

And voila! the array is in the wave-form.
 */

/*
public class Solution {
    public ArrayList < Integer > wave(ArrayList < Integer > A) {
        Collections.sort(A);
        int n = A.size();
        for (int i = 2; i <= n; i += 2) {
            exch(A, i - 2, i - 1);
        }
        return A;
    }
    private void exch(ArrayList < Integer > A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
 */