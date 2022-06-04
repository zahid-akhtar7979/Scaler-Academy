package com.scaler.assignment.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/*
 * Problem Description
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.



Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX



Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.



Output Format
Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].



Example Input
Input 1:

 A = 4  
 B = [1 2 3 4 5 6] 
Input 2:

 A = 2
 B = [15, 20, 99, 1]


Example Output
Output 1:

 [-1, -1, -1, 1, 2, 3]
Output 2:

 [-1, 15, 20, 20]


Example Explanation
Explanation 1:

 for i <= 3 output should be -1.
 for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 So, output array is [-1, -1, -1, 1, 2, 3].
 
Explanation 2:

 for i <= 1 output should be -1.
 for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
 for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
 for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
 So, output array is [-1, 15, 20, 20].
 */
public class AthLargestElement {
	
	public static void main(String[] args) {
		List<Integer>input = Arrays.asList(15, 20, 99, 1);
		System.out.println(solve(2, input));
	}
	
	
	 public static ArrayList<Integer> solve(int A, List<Integer> B) {
		 
		 ArrayList<Integer>resultList = new ArrayList<>();
		 PriorityQueue<Integer>minHeap = new PriorityQueue<>();
		 
		 for(int i = 0 ;i <A-1 ;i++) {
			 minHeap.add(B.get(i));
			 resultList.add(-1);
		 }
		 minHeap.add(B.get(A-1));
		 resultList.add(minHeap.peek());
		 
		 for(int k = A ;k <B.size();k++) {    
			 
			 if(minHeap.peek() >= B.get(k)) {
				 
				 resultList.add(minHeap.peek());
				 
			 }
			 else {
				 
				 minHeap.poll();
				 minHeap.add(B.get(k));
				 resultList.add(minHeap.peek());
			 }
			
		 }
		 
		 return resultList;
	 }
	

}

/*
 * One solution is to use a Min Heap of size k to store k largest numbers.
The Kth highest element is always at the root and can be found in O(1) time.

How to process a new number?
Compare the new number value X with the root of the heap. If X is smaller, then ignore it.
Otherwise, replace root with X and call heapify for the root of the modified heap.

The time complexity of adding a new element and finding the Kth highest element is O(logK).
STL priority queue can be used to implement a heap directly.
 */

/*
 * public class Solution {
  public int[] solve(int A, int[] B) {
    PriorityQueue < Integer > pq = new PriorityQueue();
    int n = B.length;
    int[] ans = new int[n];

    for (int i = 0; i < A; i++) {
      pq.offer(B[i]);
      if (i != A - 1) ans[i] = -1;
      else ans[i] = pq.peek();
    }

    for (int i = A; i < n; i++) {
      if (B[i] <= pq.peek()) {
        ans[i] = pq.peek();
      } else {
        pq.poll();
        pq.offer(B[i]);
        ans[i] = pq.peek();
      }
    }
    return ans;
  }
}
 */


