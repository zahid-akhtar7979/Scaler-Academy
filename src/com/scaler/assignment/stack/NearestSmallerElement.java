package com.scaler.assignment.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestSmallerElement {
	
	public static void main(String[] args) {
		
		System.out.println(prevSmaller(Arrays.asList(4, 5, 2, 10, 8)));
		
	}
	
	public 	static ArrayList<Integer> prevSmaller(List<Integer> A) {
		
		
		Stack<Integer>elementStack = new Stack<>();
		ArrayList<Integer>resultList = new ArrayList<Integer>();
		
		for(int i = 0 ;i<A.size(); i++) {
			
			if(elementStack.isEmpty()) {
				resultList.add(-1);
			}
			
			else {
				if(elementStack.peek() < A.get(i)) {
					resultList.add(elementStack.peek());
				}
				else {
					while(!elementStack.isEmpty() && elementStack.peek() >= A.get(i)) {
						elementStack.pop();
					}
					if(elementStack.isEmpty()) {
						resultList.add(-1);
					}
					else {
						resultList.add(elementStack.peek());
					}
				}
			}
			elementStack.push(A.get(i));
			
			
		}
		
		return resultList;
    }

}
