package com.scaler.assignment.queue;

import java.util.LinkedList;




/*
 * Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000



Input Format
The only argument given is an integer A.



Output Format
Return a string that denotes the Ath Perfect Number.



Example Input
Input 1:

 A = 2
Input 2:

 A = 3


Example Output
Output 1:

 22
Output 2:

 1111


Example Explanation
Explanation 1:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:

First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
 */

public class PerfectNumbers {
	
	public static void main(String[] args) {
		
		System.out.println(solve(3));
		
	}
	
	public static String solve(int A) {
		
		LinkedList<String>queue= new LinkedList<>();
		queue.add("1");
		queue.add("2");
		
		while(A >1) {
			
			String frontElement = queue.poll();
			queue.add(frontElement + "1");
			queue.add(frontElement + "2");
			A--;
			
		}
		
		return queue.peek() + new StringBuilder(queue.peek()).reverse().toString();
    }

}




/*
 * Solution Approach
Can you precompute the answer of all times and
then answer as the queries come in??
It appears that we can use Queue and precompute for 100000 Perfect numbers.
First insert “1” and “2” and then use s -> s+’1’
and s -> s+’2’
to fill up the queue.
 */

/*
 * public class Solution {
    public String solve(int A) {
        Queue < String > q = new LinkedList < String > ();
        if (A == 1)
            return "11";
        else if (A == 2)
            return "22";
        q.add("1");
        q.add("2");
        int cur = 2;
        String ans = new String();
        while (q.size() < A) {
            StringBuilder sb = new StringBuilder(q.peek());
            q.remove();
            sb.append("1");
            q.add(sb.toString());
            cur++;
            if (cur == A)
                ans = sb.toString();
            sb.deleteCharAt(sb.length() - 1);
            sb.append("2");
            cur++;
            if (cur == A)
                ans = sb.toString();
            q.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder(ans);
        return ans + sb.reverse().toString();
    }
}
 */








