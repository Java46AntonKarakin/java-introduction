package java46antonkarakin.numbers;

public class AKIntegerPrimitives {

	/* ------------------byte------------------ */
	public static byte getMaxByte() {
		byte res = 1;
		while (res > 0) {
			res = (byte) (res * 2);
		}
		return (byte) (res - 1);
	}

	public static byte getMinByte() {
		return (byte) (getMaxByte() + 1);
	}

	public static int getLengthByte() {
		int res = 0;
		byte tempCounter = 1;
		while (tempCounter > 0) {
			tempCounter = (byte) (tempCounter * 2);
			res++;
		}
		return (res + 1) / 8;
	}

	/* ------------------short------------------ */

	public static short getMaxShort() {
		short res = 1;
		while (res > 0) {
			res = (short) (res * 2);
		}
		return (short) (res - 1);
	}

	public static short getMinShort() {
		return (short) (getMaxShort() + 1);
	}

	public static int getLengthShort() {
		int res = 0;
		short tempCounter = 1;
		while (tempCounter > 0) {
			tempCounter = (short) (tempCounter * 2);
			res++;
		}
		return (res + 1) / 8;
	}

	/* ------------------int------------------ */

	public static int getMaxInt() {
		int res = 1;
		while (res > 0) {
			res = res * 2;
		}
		System.out.println("intRES " + (res - 1));
		return res - 1;
	}

	public static int getMinInt() {
		return getMaxInt() + 1;
	}

	public static int getLengthInt() {
		int res = 0;
		int tempCounter = 1;
		while (tempCounter > 0) {
			tempCounter = tempCounter * 2;
			res++;
		}
		return (res + 1) / 8;
	}

	/* ------------------long------------------ */

	public static long getMaxLong() {
		long res = 1;
		while (res > 0) {
			res = res * 2;
		}
		return res - 1;
	}

	public static long getMinLong() {
		return getMaxLong() + 1;
	}

	public static Integer getLengthLong() {
		int res = 0;
		long tempCounter = 1;
		while (tempCounter > 0) {
			tempCounter = tempCounter * 2;
			res++;
		}
		return (res + 1) / 8;
	}

	/* ------------------char------------------ */
	public static char getMaxChar() {
		char res = 1;
		while (res > 0) {
			res = (char) (res * 2);
		}
		return (char) (res - 1);
	}

	public static char getMinChar() {
		return (char) (getMaxChar() + 1);
	}

	public static Integer getLengthChar() {
		int res = 0;
		char tempCounter = 1;
		while (tempCounter > 0) {
			tempCounter = (char) (tempCounter * 2);
			res++;
		}
		return (res + 1) / 8;
	}

	/* ------------------getLengthOfAll------------------ */

}