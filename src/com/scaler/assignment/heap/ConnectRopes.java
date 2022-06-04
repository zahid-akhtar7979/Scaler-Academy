package com.scaler.assignment.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/*
 * Problem Description
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000



Input Format
The only argument given is the integer array A.



Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 33
Output 2:

 182


Example Explanation
Explanation 1:

 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
Explanation 2:

 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
 */

public class ConnectRopes {
	
	public static void main(String[] args) {
		
		List<Integer>input = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(solve(input));
		
	}
	
	 public static int solve(List<Integer> A) {
		 
		 PriorityQueue<Integer>minHeap = new PriorityQueue<>();
		 minHeap.addAll(A);
			
			int minCost = 0;
			
			while(minHeap.size() != 1) {
				
				int minElement1 = minHeap.poll();
				int minElement2 = minHeap.poll();
				int cost = minElement2 + minElement1;
				
				minHeap.add(cost);
				
				minCost = minCost + cost;
			}
			
			return minCost;
	 }

}

/*
 * As mentioned in the hint, We should combine the ropes of minimum length first to get the minimum overall cost.
Let’s try to observe with an example: Suppose we are given four ropes of lengths 4, 6, 8, and 10.

1) First connect ropes of lengths 4 and 6. Now, we have three ropes of length 10(4 + 6), 8 and 10.
2) Now connect ropes of lengths 8 and 10. Now, we hace two ropes of length 18(8 + 10) and 10(4 + 6).
3) Now connect both the ropes with cost 18(8 + 10) + 10(4 + 6) = 28 (4 + 6 + 8 + 10).

So, total cost is 28 + 10 + 18 = 56. If we try to connect in some other way, the cost will >= 56.

Let’s find how many times each given initial length is added to the final cost.

In the first step, combine 4 and 6 and the cost of connecting them is 10 = 4 + 6.
In second step, combine 8 + 10(4 + 6) and cost of connecting them is 18 = 8 + 4 + 6.
In last step, combine 18 + 10 and cost of connecting them is 28 = 8 + 4 + 6 + 10.

So, it is easy to observe that 4 and 6 are added the most number of times,
lengths of the ropes which are picked first are included more than once in the total cost.
So, the idea is to connect the smallest two ropes first and recur for the remaining ropes.

To find the answer, always take the two ropes with the smallest lengths and combine these ropes.
Keep on doing this until we have only one rope left. This can easily be done using priority_queue.
*/


/*
 * public class Solution {
    public int solve(int[] A) {

        PriorityQueue < Integer > pq = new PriorityQueue();
        int cost = 0;

        // insert all elements in the queue
        for (int x: A) {
            pq.offer(x);
        }

        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() != 1) {

            // Take the two ropes with smallest length
            int l1 = pq.poll();
            int l2 = pq.poll();
            // cost of combining these two ropes is l1 + l2.
            cost += l1 + l2;

            // add the newly formed rope of length l1 + l2 to the queue.
            pq.offer(l1 + l2);
        }

        return cost;
    }
}
 */