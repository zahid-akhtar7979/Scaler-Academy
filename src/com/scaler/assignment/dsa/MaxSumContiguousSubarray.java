package com.scaler.assignment.dsa;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000



Input Format
The first and the only argument contains an integer array, A.



Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.



Example Input
Input 1:

 A = [1, 2, 3, 4, -10]
Input 2:

 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]


Example Output
Output 1:

 10
Output 2:

 6


Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));

    }
    public static int maxSubArray(final List<Integer> A) {

        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;

        for(int element :A){
            currentSum = currentSum + element;

            if(currentSum > maxSum){
                maxSum = currentSum;
            }

            if(currentSum < 0){
                currentSum = 0;
            }

        }
        return maxSum;
    }
}
/*
Let us say Ai, Ai+1 … Aj is our optimal solution.

Note that no prefix of the solution will ever have a negative sum.

Let us say Ai … Ak prefix had a negative sum.

Sum ( Ai Ai+1 … Aj ) = Sum (Ai … Ak) + Sum(Ak+1 … Aj)

Sum ( Ai Ai+1 … Aj) - Sum(Ak+1 … Aj) = Sum(Ai … Ak)

Now, since Sum(Ai … Ak) < 0,

Sum (Ai Ai+1 … Aj) - Sum (Ak+1 … Aj) < 0

which means Sum(Ak+1 … Aj ) > Sum (Ai Ai+1 … Aj)

This contradicts the fact that Ai, Ai+1 … Aj is our optimal solution.

Instead, Ak+1, Ak+2 … Aj will be our optimal solution.

Similarly, you can prove that it is always good to include a prefix with a positive sum for the optimal solution.

Try to come up with a solution based on the previous 2 facts.

If this still does not make sense, watch this video for a more detailed explanation :
 */

/*
public class Solution {
	// DO NOT MODFIY THE LIST.
	public int maxSubArray(final List<Integer> A) {
	    int sum = Integer.MIN_VALUE;
	    int last = 0;

	    for (int num : A) {
	        last += num;
	        sum = Math.max(sum, last);
	        if (last < 0)
	            last = 0;
	    }
	    return sum;
	}
}
 */