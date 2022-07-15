package telran.text;

import java.util.regex.Pattern;

public class Strings {

	public static String javaVariableRegex() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	public static boolean isArithmeticExpression(String expression) {
		if (!checkParentheses(expression)) {
			return false;
		}
		expression = removeSpacesAndParentheses(expression);
		return expression.matches(arithmeticExpression(expression));
	}

	/**
	 * 
	 * @return regular expression for arithmetic expression with no parentheses
	 *         operation: +, -, *, / [/*+-] all operations are binary operand:
	 *         either java variable or integer number or double number, for example
	 *         a ; __; 10; 10.2; 10.0 assumption: placing of parentheses is not
	 *         considered a + ((10) * 2) => a+10*2 a + ((10) * )2 => a+10*2
	 *         according to assumption a + (-10 * 2) => wrong [\\w] [+/*-]
	 * 
	 * 
	 */
	public static String arithmeticExpression(String expression) {
		StringBuilder baseEx = new StringBuilder ("[A-Za-z0-9]+");
		StringBuilder addEx = new StringBuilder ("[+/*-]{1}[A-Za-z0-9]+");
		boolean crutch = true;
		
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '/'
					|| expression.charAt(i) == '*') {
				baseEx.append(addEx);
				crutch = false;
			}
		}
		return crutch?"":baseEx.toString();
	}

	/**
	 * 
	 * @param expression returns string with no parentheses and no spaces
	 */
	private static String removeSpacesAndParentheses(String expression) {
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != '(' && expression.charAt(i) != ')' && expression.charAt(i) != ' ') {
				sb1.append(expression.charAt(i));
			}
		}
		return sb1.toString();
	}

	/**
	 * 
	 * @param expression
	 * @return true if for each '(' there is ')' examples: (ab)(dg(g)) - true
	 *         (ab))((cd) - false
	 */

	private static boolean checkParentheses(String expression) {
		int bracketsRatio = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				bracketsRatio++;
			}
			if (expression.charAt(i) == ')') {
				bracketsRatio--;
			}
			if (bracketsRatio < 0) {
				return false;
			}
		}
		return bracketsRatio == 0 ? true : false;
	}

}