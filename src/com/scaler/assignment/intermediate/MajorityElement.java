package com.scaler.assignment.intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.



Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109


Input Format
Only argument is an integer array.


Output Format
Return an integer.


Example Input
[2, 1, 2]


Example Output
2


Example Explanation
2 occurs 2 times which is greater than 3/2.
 */

public class MajorityElement {

    public static void main(String[] args) {

        System.out.println(majorityElement(Arrays.asList(2, 1, 2)));

    }

    public static int majorityElement(final List<Integer> A) {

        Map<Integer,Integer> freCount = new HashMap<>();
        for (Integer element : A){
            freCount.put(element, freCount.getOrDefault(element,0) + 1);
        }
        for (Integer key : freCount.keySet()){
            if(freCount.get(key) > A.size()/2){
                return key;
            }
        }
        return 1;
    }
}

/*
Solution Approach
If we cancel out each occurrence of an element X with all the other elements that are different from X, then X will exist till the end if it is a majority element.
Loop through each element and maintain a count of the element that has the potential of being the majority element.
If the next element is the same, then increments the count, otherwise decrements the count.
If the count reaches 0, then update the potential index to the current element and reset the count to 1.
 */


/*
public class Solution {
	public int majorityElement(final List<Integer> A) {
	    if (A == null)
	        return -1;
	    int maj = A.get(0);
	    int count = 1;
	    int n = A.size();
	    for (int i = 1; i < n; i++) {
	        if (A.get(i) == maj) {
	            count++;
	        } else if (count == 1) {
	            maj = A.get(i);
	        } else {
	            count--;
	        }
	    }
	    count = 0;
	    for (int i = 0; i < n; i++) {
	        if (A.get(i) == maj)
	            count++;
	    }
	    if (count > n / 2)
	        return maj;
	    return -1;
	}
}
 */
