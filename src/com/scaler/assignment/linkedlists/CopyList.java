package com.scaler.assignment.linkedlists;



/*
 * Problem Description
A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.



Problem Constraints
0 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of linked list A.



Output Format
Return a pointer to the head of the required linked list.



Example Input
Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Output
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Explanation
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.


 */

class RandomListNode {
	
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyList {
	
	
	public static void main(String[] args) {
		
		
		RandomListNode start = new RandomListNode(1);
        start.next = new RandomListNode(2);
        start.next.next = new RandomListNode(3);
        start.next.next.next = new RandomListNode(4);
        start.next.next.next.next = new RandomListNode(5);
 
        // 1's random points to 3
        start.random = start.next.next;
 
        // 2's random points to 1
        start.next.random = start;
 
        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random
            = start.next.next.next.next;
 
        // 5's random points to 2
        start.next.next.next.next.random = start.next;
        
//        System.out.println("Original list : ");
//        print(start);
//        
       print(copyRandomList(start));
 
 
		
	}
	
	
	 public static RandomListNode copyRandomList(RandomListNode head) {
		 
		 
		 RandomListNode start = head;
			RandomListNode current = head;
			 
			 while(start != null) {
				 
				 current = start.next;
				 RandomListNode temp = new RandomListNode(start.label);
				 start.next = temp;
				 temp.next = current;
				 start = current;
			 }
			 
			 start = head;
			 
			 while(start!= null) {
				 
	             if(start.random != null ){
	                start.next.random = start.random.next;
	             }
				 start = start.next.next;
				 
			 }
			 
			 start = head;
			 current = start.next.next;
			 RandomListNode dummy = start.next;
			 RandomListNode dummyPtr = dummy;
			 
			 //RandomListNode dummy  = new RandomListNode(Integer.MIN_VALUE);
			 
			 while(current != null) {
				 
				 dummyPtr.next = current.next;
				 start.next = current;
				 dummyPtr = dummyPtr.next;
				 start = current;
				 current = current.next.next;
				 
			 }
			 
			 return dummy;   
	 	}
	 
	 static void print(RandomListNode start)
	    {
		 RandomListNode ptr = start;
	        while (ptr != null) {
	            System.out.println("Data = " + ptr.label
	                               + ", Random = "
	                               + ptr.random.label);
	            //System.out.println("Data = " + ptr.label);
	            ptr = ptr.next;
	        }
	    }
}


/*
 * There are 2 approaches to solving this problem.

Approach 1: Using hashmap.
Use a hashmap to store the mapping from oldListNode to the newListNode. Whenever you encounter a new node in the oldListNode (either via a random pointer or through the next pointer ), create the newListNode, store the mapping. And update the next and random pointers of the newListNode using the mapping from the hashmap.

Approach 2 : Using 2 traversals of the list.
Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A’->B->B’->C->C’

Step2: copy the random links: for each new node n’, n’.random = n.random.next

Step3: detach the list: basically n.next = n.next.next; n’.next = n’.next.next
 */



/*
 * public class Solution {
    private HashMap < RandomListNode, RandomListNode > hashMap;
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node, newHead, newNode;
        hashMap = new HashMap < > ();
        node = head;
        newHead = null;
        while (node != null) {
            newNode = new RandomListNode(node.label);
            if (newHead == null)
                newHead = newNode;
            hashMap.put(node, newNode);
            node = node.next;
        }
        for (Map.Entry < RandomListNode, RandomListNode > entry: hashMap.entrySet()) {
            node = entry.getKey();
            newNode = entry.getValue();
            if (node.next != null) {
                newNode.next = hashMap.get(node.next);
            }
            if (node.random != null) {
                newNode.random = hashMap.get(node.random);
            }
        }
        return newHead;
    }
}
 * 
 */







