package telran.text;

public class Strings {

	public static boolean isArithmeticExpression(String expression) {
		if (!checkParentheses(expression)) {
			return false;
		}
		return removeSpacesAndParentheses(expression).matches(arithmeticExpression(expression));
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
	 */
	public static String arithmeticExpression(String expression) {
		boolean crutch = true;

		StringBuilder regExpForCorrectVar = new StringBuilder("([A-Za-z0-9]+\\.[A-Za-z0-9]+|[A-Za-z0-9]+|__+)");
		StringBuilder addExpForActPlusVar = new StringBuilder(
				"([+/*-]{1}(([A-Za-z0-9]+\\.[A-Za-z0-9]+)|([A-Za-z0-9]+)|__+))");
		String regExMathSymbol = "[*/+-]";

		for (int i = 0; i < expression.length(); i++) {
			if (Character.toString(expression.charAt(i)).matches(regExMathSymbol)) {
				regExpForCorrectVar.append(addExpForActPlusVar);
				crutch = false;
			}
		}
		return crutch ? "" : regExpForCorrectVar.toString();
	}

	/**
	 * 
	 * @param expression returns string with no parentheses and no spaces
	 */
	private static String removeSpacesAndParentheses(String expression) {
		StringBuilder sb1 = new StringBuilder();
		String regExMathSymbol = "[() ]";
		for (int i = 0; i < expression.length(); i++) {
			if (!Character.toString(expression.charAt(i)).matches(regExMathSymbol)) {
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
		String mathSymbolsAndBrackets = "[+/*-]";
		String regExpBeginWithBrOpen = "(\\()*[0-9]+\\.[0-9]+|(\\()*[A-Za-z0-9]+|(\\()*__+";
		String regExpBeginWithBrClose = "[0-9]+\\.[0-9]+(\\))*|[A-Za-z0-9]+(\\))*|__+(\\))*";
		String regExpNoBrackets = "[0-9]+\\.[0-9]+|[A-Za-z0-9]+|__+";
		String[] ExpStrArr = expression.split(mathSymbolsAndBrackets);
		int bracketsRatio = 0;

		for (int i = 0; i < ExpStrArr.length; i++) {

			if (ExpStrArr[i].contains(")") || ExpStrArr[i].contains("(")) {

				if (ExpStrArr[i].startsWith(")")) {
					return false;
				}
				if (ExpStrArr[i].endsWith("(")) {
					return false;
				}
				if (ExpStrArr[i].startsWith("(") && ExpStrArr[i].matches(regExpBeginWithBrOpen)) {
					bracketsRatio++;
				}
				if (ExpStrArr[i].endsWith(")") && ExpStrArr[i].matches(regExpBeginWithBrClose)) {
					bracketsRatio--;
				}
			} else {
				if (!ExpStrArr[i].matches(regExpNoBrackets)) {
					return false;
				}
			}
		}
		return bracketsRatio == 0 ? true : false;
	}
}