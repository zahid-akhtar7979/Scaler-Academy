package com.scaler.assignment.linkedlists;


/*
 * Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
Only argument is the head of the linked list.



Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
 */


public class RemoveLoopFromLinkedList {
	
	public static void main(String[] args) {
		
//		ListNode node = new ListNode(10);
//		node.next = new ListNode(11);
//		node.next.next = new ListNode(12);
//		node.next.next.next = new ListNode(13);
		
		
		
		ListNode node = new ListNode(50);
        node.next = new ListNode(20);
        node.next.next = new ListNode(15);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(10);
 
        // Creating a loop for testing
        node.next.next.next.next.next = node.next.next;
		
		//System.out.println(solve(node));
		print((solve(node)));
		
		
	}
	
	
	 public static ListNode solve(ListNode a) {
		 
		 
			ListNode slowPtr = a;
			ListNode fastPtr = a;

			ListNode startPtr = a;

			while (fastPtr != null && fastPtr.next != null) {

				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next.next;

				if (slowPtr == fastPtr) {

					while (startPtr.next != slowPtr.next) {
						startPtr = startPtr.next;
						slowPtr = slowPtr.next;
					}

					slowPtr.next = null;
					break;

				}

			}

			return a;
		}
	 
	 static void print(ListNode start)
	    {
		 ListNode ptr = start;
	        while (ptr != null) {
	            System.out.println("Data = " + ptr.val);
	            //System.out.println("Data = " + ptr.label);
	            ptr = ptr.next;
	        }
	    }
}


/*
 * Solution Approach
You just need to find what the point is, which has 2 pointers pointing towards it.
Once you have found it, remove one of the pointers and return the head of the new linked list.
 */


/*
 * public class Solution {
    public ListNode solve(ListNode A) {
        detectAndRemoveLoop(A);
        return A;
    }
    int detectAndRemoveLoop(ListNode node) {
        ListNode slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present 
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

   
    void removeLoop(ListNode loop, ListNode curr) {
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        ptr1 = curr;
        while (1 == 1) {
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }
            
            if (ptr2.next == ptr1) {
                break;
            }
           
            ptr1 = ptr1.next;
        }
       
        ptr2.next = null;
    }

}
 */



















