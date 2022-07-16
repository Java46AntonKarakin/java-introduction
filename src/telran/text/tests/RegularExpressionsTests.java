package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.text.Strings.*;

class RegularExpressionsTests {

	@Test
	void isArithmeticExpressionTestTrue () {
		
		String exp1 = "(12+__)";
		String exp2 = "(12+34)*__+(c/de-f)";
		String exp3 = "1+__";

	
	assertTrue(isArithmeticExpression(exp1));
	assertTrue(isArithmeticExpression(exp2));
	assertTrue(isArithmeticExpression(exp3));
	
	
	}
	void isArithmeticExpressionTestFalse () {
		
		String exp1 = ")12+34)*abc/de-f";
		String exp2 = "(12+34)*abc/de-f)";
		String exp3 = "(12+3-(-4)*abc/de-f)";
		String exp4 = "(12+34)*ab(c/de-f_)";
		String exp5 = "(12+34)*ab(c/de-+f)";
		String exp6 = "123+";
		String exp7 = "f";
		
		assertFalse(isArithmeticExpression(exp1));
		assertFalse(isArithmeticExpression(exp2));
		assertFalse(isArithmeticExpression(exp3));
		assertFalse(isArithmeticExpression(exp4));
		assertFalse(isArithmeticExpression(exp5));
		assertFalse(isArithmeticExpression(exp6));
		assertFalse(isArithmeticExpression(exp7));
	}

}
