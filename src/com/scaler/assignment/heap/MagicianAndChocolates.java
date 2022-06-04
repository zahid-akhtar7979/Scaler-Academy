package com.scaler.assignment.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;



/*
 * Problem Description
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105



Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.



Output Format
Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.



Example Input
Input 1:

 A = 3
 B = [6, 5]
Input 2:

 A = 5
 b = [2, 4, 6, 8, 10]


Example Output
Output 1:

 14
Output 2:

 33


Example Explanation
Explanation 1:

 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
Explanation 2:

 Maximum number of chocolates that can be eaten is 33.
 */

public class MagicianAndChocolates {
	
	public static void main(String[] args) {
		
		List<Integer>input = Arrays.asList(2147483647, 2000000014, 2147483647);
		System.out.println(nchoc(10, input));
		
	}
	
	public static int nchoc(int A, List<Integer> B) {
		
		
		PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.addAll(B);
		
		long maxChocolates = 0;
		
		for(int i =0; i<A; i++) {
			
			int maxElement = maxHeap.poll();
			maxChocolates = maxChocolates + maxElement;
			maxHeap.add((int)Math.floor(maxElement/2));
		}
		
		return (int) (maxChocolates  % (Math.pow(10, 9) + 7));
    }

}


/*
 * The solution to this problem can be found greedily.

At any time t, the kid will always choose the bag with the maximum number of chocolates and consume all its chocolates.
So we need to maintain the current maximum size among all bags for every time t = 1, … , B and also update the sizes of the bags.

This can be done using a max heap : https://en.wikipedia.org/wiki/Min-max_heap

Time Complexity:- O(AlogN + N)
Space Complexity:- O(N)
*/


/*
 * public class Solution {
    static long mod = 1000000007;
    public int nchoc(int A, int[] B) {
        int N = B.length;
        int K = A;
        long ans = 0;
        PriorityQueue < Integer > heap = new PriorityQueue(new CustomComp());
        for (int a: B)
            heap.offer(a);
        while (K > 0) {

            //Get maximum element from the heap 
            long max_elem = (long) heap.poll();

            // Add the maximum element to the answer
            ans += max_elem;
            ans = ans % mod;
            // push the floor(A[i]/2) back to the heap.
            heap.offer((int)(max_elem / 2));
            K--;
        }
        return (int) ans;
    }
}

class CustomComp implements Comparator < Integer > {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
 */












