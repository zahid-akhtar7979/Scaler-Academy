package com.scaler.assignment.intermediate.BasicMaths;
import java.util.Arrays;
import java.util.List;

/*
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
 */


public class RearrangeArray {
	
	public static void main(String[] args) {
		
		arrange(Arrays.asList(4, 0, 2, 1, 3));
	}
	
	public static void arrange(List<Integer> a) {
		
		System.out.println("list before rearranging"+a);
		
		int len = a.size();
		for(int i = 0; i<len ;i++) {
			a.set(i, a.get(i)*len);
		}
		for(int i = 0; i<len ;i++) {
			a.set(i, a.get(i) + a.get(a.get(i)/len)/len);
		}
		
		for(int i = 0; i<len ;i++) {
			a.set(i, a.get(i) % len);
		}
		System.out.println("list before rearranging"+a);
	}

}


/*
 * If you had extra space to do it, the problem will be very easy.
Store a copy of Arr in B.

And then for every element, do Arr[i] = B[B[i]]

Lets restate what we just said for extra space :

If we could somehow store 2 numbers in every index ( that is, Arr[i] can contain the old value and the new value somehow ), then the problem becomes very easy.
NewValue of Arr[i] = OldValue of Arr[OldValue of Arr[i]]

Now, we will do a slight trick to encode 2 numbers in one index.
This trick assumes that N * N does not overflow.

1) Increase every Array element Arr[i] by (Arr[Arr[i]] % n)*n.
2) Divide every element by N.
Given a number as

   A = B + C * N   if ( B, C < N )
   A % N = B
   A / N = C
We use this fact to encode 2 numbers into each element of Arr.
 */


/*
 * public class Solution {
	public void arrange(ArrayList<Integer> A) {
	   	    int n = A.size();
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
	}
}
 */









