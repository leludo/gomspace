package interview;

import java.util.Stack;

/**
 * The exercise purpose is to provide a simple algorithm to check if a given
 * string contains a balanced opening and closing characters. The list of given
 * opening and closing characters are provided as constants
 */
public class BalancedStringChecker {

	private static final String OPENING = "([{";
	private static final String CLOSING = ")]}";

	/**
	 * The given String parameter is parsed character per character in order to
	 * check if it is balanced or not.
	 * 
	 * @param checked the checked String
	 * @return false if the given String is unbalanced, true in all other cases
	 */
	public static boolean isBalanced(final String checked) {
		final Stack<Character> openings = new Stack<>();

		if (checked != null && checked.length() > 0) {

			for (char current : checked.toCharArray()) {
				if (isOpening(current)) {
					// we maintain a list of ordered opening chars
					openings.push(current);
				} else if (isClosing(current)) {
					if (openings.isEmpty()) {
						// the character musn't be a closing in case no opening char registered
						return false;
					} else {
						if (isOpposite(openings.peek(), current)) {
							/*
							 * The closing character must be the corresponding character to validate that
							 * the order of opening and closing is consistent. The matching opening
							 * character is removed from the opening chars stack
							 */
							openings.pop();
						} else
							// both characters are not matching, we can stop the process now
							return false; 
					}
				}
			}
		}
		/*
		 * The opening stack must be emptied by the matching closing chars, if not some
		 * closing chars are missing and therefore the string is not balanced
		 */
		return openings.isEmpty();
	}

	/**
	 * Check is the given char is a closing char
	 * 
	 * @param c the character to test
	 * @return true if the char is found in the closing chars definition
	 */
	private static boolean isOpening(char c) {
		return OPENING.indexOf(c) >= 0;
	}

	/**
	 * Check if the given character is a closing character
	 * 
	 * @param c the character to test
	 * @return true if the char is found in the closing chars definition
	 */
	private static boolean isClosing(char c) {
		return CLOSING.indexOf(c) >= 0;
	}

	/**
	 * Will check is the index of the first parameter is the same of the second in
	 * both tables. A given character is considered as opposite to another if it
	 * represent the opposite opening of closing character. (i.e: [ is opposite to ]
	 * and } is opposite to { ... and so on. )
	 * 
	 * @param a the first character to test
	 * @param b the second character to test
	 * @return true if a is the opposite of b, false otherwise
	 */
	private static boolean isOpposite(char a, char b) {
		return (OPENING.indexOf(a) == CLOSING.indexOf(b)) || (OPENING.indexOf(b) == CLOSING.indexOf(a));
	}

}
