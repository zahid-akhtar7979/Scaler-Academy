package com.scaler.assignment.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/*
 * Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return an integer array C, C[i] denotes the median of the first i elements.



Example Input
Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation
Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 
 */

public class RunningMedian {
	
	public static void main(String[] args) {
		
		System.out.println(solve(Arrays.asList(1, 2, 5, 4, 3)));
		
	}
	
	
	public static List<Integer> solve(List<Integer> A){
		
		
		List<Integer>resultList = new ArrayList<Integer>();
		PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		PriorityQueue<Integer>minHeap = new PriorityQueue<>();
		
		
		for(Integer element : A) {
			
			if(maxHeap.isEmpty()) {
				maxHeap.add(element);
			}
			
			else if(maxHeap.size() == minHeap.size()) {
				
				int ele = minHeap.peek();
				
				if(element < ele) {
					maxHeap.add(element);
				}
				
				else {
					minHeap.poll();
					minHeap.add(element);
					maxHeap.add(ele);
					
				}
			}
			
			else {
				
				if(minHeap.isEmpty()) {
					
					if(element > maxHeap.peek()) {
						
						minHeap.add(element);
					}
					
					else {	
						
						int ele = maxHeap.peek();
						maxHeap.poll();
						minHeap.add(ele);
						maxHeap.add(element);
					}
				}
				
				else if(element >= minHeap.peek()) {
					minHeap.add(element);
				}
				
				else {
					if(element <maxHeap.peek() ) {
						int ele = maxHeap.peek();
						maxHeap.poll();
						minHeap.add(ele);
						maxHeap.add(element);
					}
					
					else {
						
						minHeap.add(element);
					}
					
				}
			}
			resultList.add(maxHeap.peek());
		}
		
		return resultList;
	}

}

/*
 * As it is mentioned in the hint, the median is an element of the array such that half elements are smaller and half elements are greater than that element.

So, the idea is to use max heap and min heap to store the elements of the higher half and lower half.

Max heap and min heap can be implemented using STL.

Algorithm

Create two heaps. One max heap to maintain elements of the lower half and one min heap to maintain elements of the higher half at any point in time.
Take the initial value of the median as 0.
For every newly read element, insert it into either max heap or min-heap and calculate the median based on the following conditions:

1 If the size of the max-heap is greater than the size of the min-heap and the element is less than the previous median, then pop the top element from the max-heap and insert it into the min-heap and insert the new element into the max-heap else insert the new element to min-heap. Calculate the new median as the average of the top of elements of both max and min-heap.

2 If the size of the max-heap is less than the size of the min-heap and the element is greater than the previous median, then pop the top element from the min-heap and insert it into the max heap and insert the new element to the min-heap else insert the new element to max-heap. Calculate the new median as the average of the top of elements of both max and min-heap.

3 If the size of both heaps are the same. Then check if the current is less than the previous median or not. If the current element is less than the previous median, then insert it into the max-heap, and the new median will be equal to the top element of the max-heap. If the current element is greater than the previous median, then insert it into the min-heap, and the new median will be equal to the top element of the min-heap.

Time Complexity:- O(NlogN)
Space Complexity:- O(N)
 */


/*
 * public class Solution {
	  static PriorityQueue < Integer > max_heap;
	  static PriorityQueue < Integer > min_heap;
	  public int[] solve(int[] A) {
	    min_heap = new PriorityQueue();
	    max_heap = new PriorityQueue(new CustomComp());
	    int n = A.length;
	    int[] ans = new int[n];
	    for (int i = 0; i < n; ++i) {
	      add(A[i]);
	      ans[i] = get_median();
	    }
	
	    return ans;
	  }
	  public static int get_median() {
	    int total = min_heap.size() + max_heap.size();
	    int ret;
	    if (total % 2 == 1) {
	      if (max_heap.size() > min_heap.size())
	        ret = max_heap.peek();
	      else
	        ret = min_heap.peek();
	    } else {
	      ret = Integer.MAX_VALUE;
	      if (max_heap.size() != 0)
	        ret = Math.min(ret, max_heap.peek());
	      if (min_heap.size() != 0)
	        ret = Math.min(ret, min_heap.peek());
	    }
	    return ret;
	  }
	  public static void add(int a) {
	    if (max_heap.size() != 0 && (a >= max_heap.peek()))
	      min_heap.offer(a);
	    else
	      max_heap.offer(a);
	
	    if (Math.abs(max_heap.size() - min_heap.size()) > 1) {
	      if (max_heap.size() > min_heap.size()) {
	        int temp = max_heap.peek();
	        max_heap.poll();
	        min_heap.offer(temp);
	      } else {
	        int temp = min_heap.peek();
	        min_heap.poll();
	        max_heap.offer(temp);
	      }
	    }
	  }

}
class CustomComp implements Comparator < Integer > {
  @Override
  public int compare(Integer a, Integer b) {
    return b - a;
  }
}
 */





