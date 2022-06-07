package com.scaler.assignment.bitManipulations;

/*
Problem Description
Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111".
 */

public class AddBinaryStrings {

    public static void main(String[] args) {

        System.out.println(addBinary("1010110","1"));

    }

    public static String addBinary(String A, String B) {


        StringBuilder result = new StringBuilder();

        int i = A.length()-1;
        int j = B.length()-1;
        int carry = 0;
        int digitSum = 0;

        while(i>=0 && j >=0){

            digitSum = (A.charAt(i)-48) + (B.charAt(j)-48) + carry;

            if(digitSum >= 2){
                result.append(digitSum %2);
                carry = 1;
            }
            else{
                result.append(digitSum);
                carry = 0;
            }
            i--;
            j--;

        }

        while(i>=0){

            digitSum = (A.charAt(i)-48) + carry;
            if(digitSum >= 2){
                result.append(digitSum %2);
                carry = 1;
            }
            else{
                result.append(digitSum);
                carry = 0;
            }
            i--;
        }
        while(j>=0){
            digitSum = (B.charAt(j)-48) + carry;
            if(digitSum >= 2){
                result.append(digitSum %2);
                carry = 1;
            }
            else{
                result.append(digitSum);
                carry = 0;
            }
            j--;
        }

        if(carry == 1){
            result.append(1);
        }

        return result.reverse().toString();
    }
}
/*
Solution Approach
Since the sizes of the two strings may be different, we first make the size of the smaller string equal to that of the bigger one by adding leading 0s for simplicity. Note that you can handle the addition without adding zeroes by adding a few if statements. After making sizes the same, we add bits from the rightmost bit to the leftmost bit.
In every iteration, we must sum 3 bits: 2 bits of 2 given strings and carry.
The sum bit will be 1 if all 3 bits are set, or one of them is set.

So we can add all the bits and then take the remainder with 2 to get the current bit in the answer. How to find the carryover? Carry will be 1 if any of the two bits is set. So we can find carry by adding the bits and dividing the result by 2. Following is a step-by-step algorithm: 1. Make them equal-sized by adding 0s at the beginning of the smaller string. 2. Perform bit addition Boolean expression for adding 3 bits a, b, c Sum = (a + b + c) % 2 Carry = (a + b + c ) / 2
 */

/*
public class Solution {
	public String addBinary(String A, String B) {
	    int nA, nB;
	    char res[];
	    int i, j, k;
	    nA = A.length();
	    nB = B.length();
	    res = new char[Math.max(nA, nB) + 1];
	    k = Math.max(nA, nB);
	    i = nA - 1;
	    j = nB - 1;
	    int sum = 0, carry = 0;
	    while (i >= 0 || j >= 0 || carry != 0) {
	        sum = carry;
	        if (i >= 0)
	            sum += (A.charAt(i) - '0');
	        if (j >= 0)
	            sum += (B.charAt(j) - '0');
	        res[k] = (char) ((sum % 2) + '0');
	        carry = sum / 2;
	        i--;
	        j--;
	        k--;
	    }
	    if (res[0] == '1')
	        return new String(res);
	    int len = Math.max(nA, nB);
	    return new String(res, 1, len);
	}
}

 */