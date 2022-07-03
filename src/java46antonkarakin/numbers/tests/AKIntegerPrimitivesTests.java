package java46antonkarakin.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java46antonkarakin.numbers.AKIntegerPrimitives;

class AKIntegerPrimitivesTests {
	/* ------------------Byte------------------ */
	@Test
	void getMaxByte() {
		assertEquals(Byte.MAX_VALUE, AKIntegerPrimitives.getMaxByte());
	}

	@Test
	void getMinByte() {
		assertEquals(Byte.MIN_VALUE, AKIntegerPrimitives.getMinByte());
	}

	@Test
	void getLengthByte() {
		assertEquals(1, AKIntegerPrimitives.getLengthByte());
	}

	/* ------------------Short------------------ */
	@Test
	void getMaxShort() {
		assertEquals(Short.MAX_VALUE, AKIntegerPrimitives.getMaxShort());
	}

	@Test
	void getMinShort() {
		assertEquals(Short.MIN_VALUE, AKIntegerPrimitives.getMinShort());
	}

	@Test
	void getLengthShort() {
		assertEquals(2, AKIntegerPrimitives.getLengthShort());
	}

	/* ------------------Int------------------ */
	@Test
	void getMaxInt() {
		assertEquals(Integer.MAX_VALUE, AKIntegerPrimitives.getMaxInt());
	}

	@Test
	void getMinInt() {
		assertEquals(Integer.MIN_VALUE, AKIntegerPrimitives.getMinInt());
	}

	@Test
	void getLengthInt() {
		assertEquals(4, AKIntegerPrimitives.getLengthInt());
	}

	/* ------------------Long------------------ */
	@Test
	void getMaxLong() {
		assertEquals(Long.MAX_VALUE, AKIntegerPrimitives.getMaxLong());
	}

	@Test
	void getMinLong() {
		assertEquals(Long.MIN_VALUE, AKIntegerPrimitives.getMinLong());
	}

	@Test
	void getLengthLong() {
		assertEquals(8, AKIntegerPrimitives.getLengthLong());
	}

	/* ------------------Char------------------ */
	@Test
	void getMaxChar() {
		assertEquals(Character.MAX_VALUE, AKIntegerPrimitives.getMaxChar());
	}

	@Test
	void getMinChar() {
		assertEquals(Character.MIN_VALUE, AKIntegerPrimitives.getMinChar());
	}

	@Test
	void getLengthChar() {
		assertEquals(2, AKIntegerPrimitives.getLengthChar());
	}

}
