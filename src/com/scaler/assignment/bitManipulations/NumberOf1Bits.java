package com.scaler.assignment.bitManipulations;


/*
Problem Description
Write a function that takes an integer and returns the number of 1 bits it has.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument contains integer A


Output Format
Return an integer as the answer


Example Input
Input1:
11


Example Output
Output1:
3


Example Explanation
Explaination1:
11 is represented as 1011 in binary.
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numSetBits(3));

    }
    public static int numSetBits(int A) {

        int count = 0;
        for(int i =0 ;i<32 ;i++){
            int digitValue = (A & 1<<i);
            if(digitValue != 0){
                count++;
            }
        }
        return count;
    }

    public int numSetBitsOptimised(long A) {
        int total_ones = 0;
        while (A != 0) {
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
    }
}
/*
olution Approach
Bruteforce:
Iterate 32 times, each time determining if the ith bit is a ’1′ or not.
This is probably the easiest solution, and the interviewer would probably not be too happy about it.
This solution is also machine dependent (You need to be sure that an unsigned integer is 32-bit).
In addition, this solution is not very efficient too because you need to iterate 32 times no matter what.

A better solution:
This special solution uses a trick which is normally used in bit manipulations.
Notice what x - 1 does to bit representation of x.
x - 1 would find the first set bit from the end, and then set it to 0, and set all the bits following it.

Which means if x = 10101001010100
                              ^
                              |
                              |
                              |

                       First set bit from the end
Then x - 1 becomes 10101001010(011)

All other bits in x - 1 remain unaffected.
This means that if we do (x & (x - 1)), it would just unset the last set bit in x (which is why x&(x-1) is 0 for powers of 2).

Can you use the above fact to come up with a solution ?

Still unable to solve the problem after this hint?
 */

/*
public class Solution {
    public int numSetBits(long A) {
        int total_ones = 0;
        while (A != 0) {
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
    }
}
 */