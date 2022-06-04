package com.scaler.assignment.intermediate.BasicMaths;


/*
 * Problem Description

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed. Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False
 */


public class PalindromeInteger {
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(-121));
	}
	
	public static  int isPalindrome(int A) {
		
		if(A < 0) {
			return 0;
		}
		
		int reverseNumber = 0;
		int input = A;
		
		while(input!=0) {
			int remainder = input%10;
			reverseNumber = reverseNumber*10 +remainder;;
			input = input/10;
		}
		if(A == reverseNumber) {
			return 1;
		}
		return 0;
    }

}


/*
 * Corner cases to consider:

1) Negative numbers

2) If you are thinking of converting the integer to string, note the restriction of using extra space.

3) Try reversing the integer.
 */


/*
 * public class Solution {
	public int isPalindrome(int A) {
	    String str = String.valueOf(A);
	    boolean pal = palindrome(str);
	    return pal ? 1 : 0;
	}
	
	public boolean palindrome(String str) {
	    int start = 0;
	    int end = str.length() - 1;
	    
	    while (start < end) {
	        if (str.charAt(start) != str.charAt(end))
	            return false;
	        start++;
	        end--;
	    }
	    
	    return true;
	}
}
 */










