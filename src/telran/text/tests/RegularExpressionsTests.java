package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

class RegularExpressionsTests {

	@Test
	void isArithmeticExpressionTestTrue() {

//		expression[0] = "(12+__)";
//		expression[1] = "(12+34)*__+(c/de-f)";
//		expression[2] = "1+__";
//		expression[3] = "((12+__))";

		String[] expression = { "(12+__)", "(12+34)*__+(c/de-f)", "1+__", "((12+__))" };

		for (int i = 0; i < expression.length; i++) {
			assertTrue(isArithmeticExpression(expression[i]));
		}

	}

	void isArithmeticExpressionTestFalse() {

//		expression[0] = ")12+34)*abc/de-f";
//		expression[1] = "(12+34)*abc/de-f)";
//		expression[2] = "(12+3-(-4)*abc/de-f)";
//		expression[3] = "(12+34)*ab(c/de-f_)";
//		expression[4] = "(12+34)*ab(c/de-+f)";
//		expression[5] = "123+";
//		expression[6] = "f";
//		expression[7] = "(12+34))";
//		expression[8] = "()";

		String[] expression = { ")12+34)*abc/de-f", "(12+34)*abc/de-f)", "(12+3-(-4)*abc/de-f)", "(12+34)*ab(c/de-f_)",
				"(12+34)*ab(c/de-+f)", "123+", "f", "(12+34))", "()" };

		for (int i = 0; i < expression.length; i++) {
			assertFalse(isArithmeticExpression(expression[i]));
		}

	}

}
