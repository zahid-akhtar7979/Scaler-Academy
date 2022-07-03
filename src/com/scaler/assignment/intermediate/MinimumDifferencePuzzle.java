package com.scaler.assignment.intermediate;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description

There is a shop whose assistant told you that there are A puzzles in the shop and you want to buy B of them. They might differ in difficulty and size. The first jigsaw puzzle consists of A1 pieces, the second one consists of A2 pieces and so on.

You decided that the difference between the numbers of pieces in bought puzzles must be as small as possible. Let x be the number of pieces in the largest puzzle that the you buy and y be the number of pieces in the smallest such puzzle. You want to choose such B puzzles that x-y is as minimum as possible. Find the least possible value of x-y.



Problem Constraints

1 <= A <= 103

1 <= B <= A

1 <= A[i] <= 106



Input Format

First argument is a vector A whose ith element represents number of pieces of ith puzzle.

Second argument is an integer B as per the question.



Output Format

Return an integer showing minimum possible value of x-y.



Example Input

Input 1:

A={10, 12, 10, 7, 5, 22}, B=4


Example Output

Output 1:

5


Example Explanation

Explanation 1:

Selected puzzles are 10, 10, 12, 7: (Max-Min) = (12-7) = 5.
 */
public class MinimumDifferencePuzzle {

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, int B) {

        Collections.sort(A);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<= A.size() - B ; i++){

            ans = Math.min(ans, A.get(i  +  B-1) - A.get(i));

        }
        return ans;
    }
}
/*
Solution Approach
In the sorted vector start iterating window wise of size B and return the minimum value of all windows (x-y) value.
 */

/*
int Solution::solve(vector<int> &A, int B) {
    int n = A.size(),ans = 999999999;
	sort(A.begin(),A.end());
	for (int i=0; i<n-B+1; i++){
		if (A[i+B-1] - A[i] < ans){
			ans = A[i+B-1] - A[i];
		}
	}
    return ans;
}

 */