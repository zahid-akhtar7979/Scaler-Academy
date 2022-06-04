package com.scaler.assignment.stack;

import java.util.Stack;

public class DoubleCharacterTrouble {

	public static void main(String[] args) {

		System.out.println(solve("bbbabbb"));

	}

	public static String solve(String A) {

		Stack<Character> characterStack = new Stack<>();
		Stack<Character> reverseCharacterStack = new Stack<>();

		for (int i = 0; i < A.length(); i++) {

			if (characterStack.isEmpty() || characterStack.peek() != A.charAt(i)) {
				characterStack.push(A.charAt(i));
			} else {
				characterStack.pop();
			}
		}

		while (!characterStack.isEmpty()) {

			reverseCharacterStack.push(characterStack.pop());
		}

		StringBuilder sb = new StringBuilder();

		while (!reverseCharacterStack.isEmpty()) {

			sb.append(reverseCharacterStack.pop());
		}

		return sb.toString();
	}

}
