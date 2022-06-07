package com.scaler.assignment.bitManipulations;


import java.util.Arrays;
import java.util.List;

/*
Problem Description
Given an array of integers, every element appears thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?




Problem Constraints
2 <= A <= 5*106

0 <= A <= INTMAX



Input Format
First and only argument of input contains an integer array A.



Output Format
Return a single integer.



Example Input
Input 1:

 A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2:

 A = [0, 0, 0, 1]


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 4 occurs exactly once in Input 1.
 1 occurs exactly once in Input 2.
 */
public class SingleNumberII {

    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1)));
    }
    public static int singleNumber(final List<Integer> A) {

        int num = 0;
        for(int i = 0 ;i <32 ;i ++){
            int sum = 0;
            for(int j = 0; j<A.size() ;j++){

                if((A.get(j) & (1<<i)) != 0){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                num = num + (1<<i);
            }
        }
        return num;
    }
}

/*
Having noticed that if X has 1 in that position, we will have a 3x+1 number of 1s in that position. If X has 0 in that position, we will have a 3x+1 number of 0 in that position.

A straightforward implementation is to use an array of size 32 to keep track of the total count of ith bit.

We can improve this based on the previous solution using three bitmask variables:

ones as a bitmask to represent the ith bit had appeared once.
Twos as a bitmask to represent the ith bit had appeared twice.
Threes as a bitmask to represent the ith bit had appeared three times.
When the ith bit had appeared for the third time, clear the ith bit of both ones and twos to 0. The final answer will be the value of ones.
 */

/*
public class Solution {
    public int singleNumber(final List < Integer > A) {
        int[] bits = new int[32];
        for (int num: A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
    }
}

 */