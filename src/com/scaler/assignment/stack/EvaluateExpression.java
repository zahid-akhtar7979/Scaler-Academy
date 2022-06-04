package com.scaler.assignment.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EvaluateExpression {
	
	public static void main(String[] args) {
		
		List<String>inputList = Arrays.asList("2", "1", "+", "3", "*");
		
		System.out.println(evalRPN(inputList));
		
	}
	
	public static int evalRPN(List<String> A) {
		
		Stack<String>expStack = new Stack<>();
		
		Set<String>operatorSet = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		
		for(int i = 0; i <A.size(); i++) {
			
			if(expStack.isEmpty() || !operatorSet.contains(A.get(i))) {
				expStack.push(A.get(i));
			}
			
			else if(A.get(i).equals("+")) {
				
				String num1String = expStack.pop();
				
				if(!expStack.isEmpty()) {
					String num2String = expStack.pop();
					
					int num1 = Integer.parseInt(num1String);
					int num2 = Integer.parseInt(num2String);
					expStack.push(String.valueOf(num2+num1));
					
				}
				else {
					expStack.push(num1String);
				}
				
			}
			
			else if(A.get(i).equals("*")) {
				
				String num1String = expStack.pop();
				
				if(!expStack.isEmpty()) {
					String num2String = expStack.pop();
					
					int num1 = Integer.parseInt(num1String);
					int num2 = Integer.parseInt(num2String);
					expStack.push(String.valueOf(num2*num1));
					
				}
				else {
					expStack.push(num1String);
				}
				
			}
			
			else if(A.get(i).equals("/")) {
				
				String num1String = expStack.pop();
				
				if(!expStack.isEmpty()) {
					String num2String = expStack.pop();
					
					int num1 = Integer.parseInt(num1String);
					int num2 = Integer.parseInt(num2String);
					expStack.push(String.valueOf(num2/num1));
					
				}
				else {
					expStack.push(num1String);
				}
				
			}
			
			else if(A.get(i).equals("-")) {
				
				String num1String = expStack.pop();
				
				if(!expStack.isEmpty()) {
					String num2String = expStack.pop();
					
					int num1 = Integer.parseInt(num1String);
					int num2 = Integer.parseInt(num2String);
					expStack.push(String.valueOf(num2-num1));
					
				}
				else {
					expStack.push(num1String);
				}
				
			}
		}
		
		return Integer.parseInt(expStack.peek());
    }

}
