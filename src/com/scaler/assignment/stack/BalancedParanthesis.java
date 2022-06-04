package com.scaler.assignment.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BalancedParanthesis {
	
	public static void main(String[] args) {
		
		System.out.println(solve("{([])}"));
	}
	
	 public static int solve(String A) {
		 
		 Stack<Character> characterStack = new Stack<>();
		 
		 Map<Character,Character>characterMap = new HashMap<>();
		 characterMap.put(')', '(');
		 characterMap.put('}', '{');
		 characterMap.put(']', '[');
		 
		 Set<Character>openBracesSet = new HashSet<>(Arrays.asList('(','{','['));
		 
		 
		 for (int i = 0; i < A.length(); i++) {
			 
				if ((!openBracesSet.contains(A.charAt(i)) && characterStack.isEmpty())) {
					return 0;
				}

				if (openBracesSet.contains(A.charAt(i))) {
					characterStack.push(A.charAt(i));
				} else if (!characterStack.isEmpty()) {

					if (characterMap.get(A.charAt(i)) == characterStack.peek()) {
						characterStack.pop();
					}
				}

			}
		 
		 return characterStack.isEmpty() ? 1:0 ;
	 }

}
