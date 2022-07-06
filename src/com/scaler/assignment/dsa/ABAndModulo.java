package com.scaler.assignment.dsa;

/*
Problem Description
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.



Problem Constraints
1 <= A, B <= 109
A != B



Input Format
The first argument is an integer A.
The second argument is an integer B.



Output Format
Return an integer denoting the greatest possible positive M.



Example Input
Input 1:

A = 1
B = 2
Input 2:

A = 5
B = 10


Example Output
Output 1:

1
Output 2:

5


Example Explanation
Explanation 1:

1 is the largest value of M such that A % M == B % M.
Explanation 2:

For M = 5, A % M = 0 and B % M = 0.

No value greater than M = 5, satisfies the condition.
 */
public class ABAndModulo {

    public int solve(int A, int B) {

        if(A == B){
            return A;
        }
        else{
            return Math.abs(A-B);
        }
    }
}
/*
Solution Approach
We can find the value of M by looping from 1 to min(A, B) and storing the maximum M, which satisfies the equation A%M == B%M.

But this approach will take time complexity of O(min(A, B)). So that will not work.

We will try to find the pattern by fixing the value of A and taking different B values.

Suppose A = 5 and B = 6. The maximum possible value of M is 1.
Suppose A = 5 and B = 7. The maximum possible value of M is 2.
Suppose A = 5 and B = 8. The maximum possible value of M is 3.
Suppose A = 5 and B = 9. The maximum possible value of M is 4.
.
.
.
So on.

It is easy to observe that the maximum value equals the absolute difference between A and B.

Try to think mathematically about why this should be the answer.
 */

/*
public class Solution {
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}
 */