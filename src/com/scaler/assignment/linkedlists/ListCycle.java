package com.scaler.assignment.linkedlists;


/*
 * Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example:

Input: 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
 */


//Definition for singly-linked list.
class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
 
public class ListCycle {
	
	public static void main(String[] args) {
		
		ListNode node = new ListNode(10);
		node.next = new ListNode(11);
		node.next.next = new ListNode(12);
		node.next.next.next = new ListNode(13);
		
		System.out.println(detectCycle(node));
		
	}
	
	public static ListNode detectCycle(ListNode a) {
		
		ListNode slowPtr = a;
		ListNode fastPtr = a;
		
		ListNode startPtr = a;
		
		while(fastPtr != null && fastPtr.next != null) {
			
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr) {
				
				while(startPtr != slowPtr) {
					startPtr = startPtr.next;
					slowPtr = slowPtr.next;
				}
				
				return startPtr;
				
			}
			
		}
		
		return null;
	}

}


/*
 * Solution Approach
Lets now look at the starting point.
If we were using hashing, the first repetition we get is the starting point. Simple!

What happens with the 2 pointer approach ?

Method 1 :
If you detect a cycle, the meeting point is definitely a point within the cycle.

Can you determine the size of the cycle ? ( Easy ) Let the size be k.
Fix one pointer on the head, and another pointer to kth node from head.
Now move them simulataneously one step at a time. They will meet at the starting point of the cycle.
Method 2 :
This might be slightly more complicated. It involves a bit of maths and is not as intuitive as method 1.
Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s, 
and the distance between the start node of cycle and the first meeting node is m.
Then
2k = (s + m + n1r)
2(s + m + n2r) = (s + m + n1r)
s + m = nr where n is an integer.
s = nr - m
s = (r - m) + (n-1)r

So, if we have one pointer on the head and another pointer at the meeting point.
 Note that since the distance between start node of cycle and the first meeting node is m, 
 therefore if the pointer moves (r - m) steps, it will reach the start of the cycle.
  When the pointer at the head moves s steps, the second pointer moves (r-m) + (n-1)r steps 
  which both points to the start of the cycle. In other words, both pointers meet first at the start of the cycle.
 */

/*
 * public class Solution {
	public ListNode detectCycle(ListNode A) {

	    HashSet<ListNode> hashSet = new HashSet<>();
	    
	    while (A != null) {
	        if (hashSet.contains(A)) {
	            return A;
	        } else {
	            hashSet.add(A);
	        }
	        A = A.next;
	    }
	    
	    return null;
	}
}
 */
















