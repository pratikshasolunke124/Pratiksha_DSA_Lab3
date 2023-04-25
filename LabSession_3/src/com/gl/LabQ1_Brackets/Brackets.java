package com.gl.LabQ1_Brackets;

import java.util.*;

public class Brackets {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the brackets");
			String bracketExpression = sc.nextLine();
			
			if (isBracketsBalanced(bracketExpression)) {
				System.out.println("The brackets are balanced");
			} else {
				System.out.println("The brackets are not balanced");
			}
		}
	}

	private static boolean isBracketsBalanced(String bracketExpression) {
		Stack<Character> stack = new Stack<>();
		char[] chars = bracketExpression.toCharArray();

		for (char c : chars) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				
				char ch = stack.pop();
				
				switch (c) {
				case ')':
					if (ch != '(') {
						return false;
					}
					break;
				case ']':
					if (ch != '[') {
						return false;
					}
					break;
				case '}':
					if (ch != '{') {
						return false;
					}
					break;

				}
			}
		}
		return stack.isEmpty();
	}
}
