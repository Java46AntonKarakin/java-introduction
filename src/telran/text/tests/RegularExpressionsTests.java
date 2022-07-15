package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

class RegularExpressionsTests {

	@Test
	void isArithmeticExpressionTest () {
		String exp1 = "(12+34)*ab(c/de-f)";
		String exp2 = ")12+34)*abc/de-f";
		String exp3 = "(12++34)*abc/de-f";
		String exp4 = "(12+3-(-4)*abc/de-f)";
		String exp5 = "_(12+34)*ab(c/de-f)";
		String exp6 = "11";
		String exp7 = "1+1";

	
	assertTrue(isArithmeticExpression(exp1));
	assertFalse(isArithmeticExpression(exp2));
	assertFalse(isArithmeticExpression(exp3));
	assertFalse(isArithmeticExpression(exp4));
	assertFalse(isArithmeticExpression(exp5));
	assertFalse(isArithmeticExpression(exp6));
	assertTrue(isArithmeticExpression(exp7));
	}

}
