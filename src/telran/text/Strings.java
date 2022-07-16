package telran.text;

public class Strings {
	
	static final String MATH_SYMBOLS_REGEX = "[+/*-]";
	static final String VAR_NAME_REGEX = "([A-Za-z\\d$]+\\.[A-Za-z\\d]+|[_A-Za-z\\d]+|__+)";

	public static boolean isArithmeticExpression(String expression) {
		if (!checkParentheses(expression)) {
			return false;
		}
		return removeSpacesAndParentheses(expression).matches(arithmeticExpression(expression));
	}

	public static String arithmeticExpression(String expression) {
		boolean crutch = true;

		StringBuilder regExpForCorrectVar = new StringBuilder(VAR_NAME_REGEX);
		StringBuilder actionPlusVaraible = new StringBuilder(
				"([+/*-]{1}(([A-Za-z\\d]+\\.[A-Za-z\\d]+)|([A-Za-z\\d]+)|__+))");
		String regExMathSymbol = "[*/+-]";

		for (int i = 0; i < expression.length(); i++) {
			if (Character.toString(expression.charAt(i)).matches(regExMathSymbol)) {
				regExpForCorrectVar.append(actionPlusVaraible);
				crutch = false;
			}
		}
		return crutch ? "" : regExpForCorrectVar.toString();
	}

	private static String removeSpacesAndParentheses(String expression) {
		expression = expression.replaceAll("[()\\s]", "");
		return expression;
	}
 
	private static boolean checkParentheses(String expression) {
		String regExpBeginWithBrOpen = "(\\()+[\\d]+\\.[\\d]+|(\\()+[A-Za-z\\d]+|(\\()+__+";
		String regExpBeginWithBrClose = "[\\d]+\\.[\\d]+(\\))+|[A-Za-z\\d]+(\\))+|__+(\\))+";
		String[] ExpStrArr = expression.split(MATH_SYMBOLS_REGEX);
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
					for (int j = 0; j < ExpStrArr[i].length(); j++) {
						if (ExpStrArr[i].charAt(j) == '(') {
							bracketsRatio++;
						}
					}
				}
				if (ExpStrArr[i].endsWith(")") && ExpStrArr[i].matches(regExpBeginWithBrClose)) {
					for (int j = 0; j < ExpStrArr[i].length(); j++) {
						if (ExpStrArr[i].charAt(j) == ')') {
							bracketsRatio--;
						}
					}
				}
			} else {
				if (!ExpStrArr[i].matches(VAR_NAME_REGEX)) {
					return false;
				}
			}
		}
		return bracketsRatio == 0 ? true : false;
	}
}