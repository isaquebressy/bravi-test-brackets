package br.com.bressy.isaque.brackets.main;

import java.util.Stack;

public class BracketsMain {

	public static void main(String[] args) {
		String string = "[{)]";

		System.out.println(match(string));

	}

	/**
	 * Brackets match method.
	 * 
	 * This method receive a string of brackets (), [] or {} and return if it is a
	 * valid balanced brackets expression. A valid expression contains no unmatched
	 * brackets and the subset of brackets enclosed within the confines of a matched
	 * pair of brackets is also a matched pair of brackets.
	 * 
	 * Examples (){}[] is valid [{()}](){} is valid []{() is not valid [{)] is not
	 * valid
	 * 
	 * @param str
	 * @return true for valid and false for invalid
	 */
	public static boolean match(String str) {
		Stack<Character> stack = new Stack<>(); // Stack opening brackets and unpack when find closing brackets

		String openning = "{[("; // Opening brackets
		String closing = "}])"; // Closing brackets

		try {
			str.chars().forEach(c -> {
				Character ch = (char) c;

				if (openning.contains(String.valueOf(ch))) { // The character is [, (, or {
					stack.add(ch); // stack the character
				} else if (closing.contains(String.valueOf(ch))) { // The character is ], ), or }
					// Match close brackets and top of stack
					if (openning.charAt(closing.indexOf(c)) == stack.peek()) {
						stack.pop(); // remove character from stack
					} else {
						throw new RuntimeException("Opening bracket not matched");
					}
				} else {
					throw new RuntimeException("Found character different of openning or closing brackets");
				}
			});
		} catch (Exception e) {
			stack.add(']'); // if exception, put char to stack to invalidate the sequence
		}

		return stack.empty() ? true : false; // if stack is empty the sequence is valid
	}

}
