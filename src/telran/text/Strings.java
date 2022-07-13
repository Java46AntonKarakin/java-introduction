package telran.text;

import java.util.Arrays;

public class Strings {
	/**
	 * 
	 * @param name1 - first name
	 * @param name2 - second name
	 * @return either "match" or "no match" in accordance to the comments (see TODO)
	 */
	public static String matches(String name1, String name2) {

		String[] arrName1 = name1.trim().split(" ");
		String[] arrName2 = name2.trim().split(" ");

		if (name1.equalsIgnoreCase(name2)) {
			return "match";
		}

		if (arrName1.length == arrName2.length) {
			if (isAbbreviation1(arrName1, arrName2)) {
				return "match";
			}
		}

		if (arrName1.length > arrName2.length) {
			if (isMiddleNameOmited(arrName1, arrName2)) {
				return "match";
			}
		}

		return "no match";
	}

	private static boolean isMiddleNameOmited(String[] arrName1, String[] arrName2) {
		for (int i = 1; i <= arrName2.length; i++) {
			if (arrName1[i].equalsIgnoreCase(arrName2[i - 1])) {
				return true;
			}
		}
		return false;
	}

	private static boolean isAbbreviation1(String[] arrName1, String[] arrName2) {
		int abr = 0;
		for (int i = 0; i < arrName1.length; i++) {
			if (arrName1[i].length() == 1) {
				abr = i;
				break;
			}
		}
		if (abr > 0) {
			for (int j = 0; j < arrName2.length; j++) {
				if (arrName2[j].startsWith(arrName1[abr])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * sorts array of strings
	 * 
	 * @param strNumbers array of strings containing the positive integer numbers
	 *                   length of each string can not be more than three symbols
	 *                   String containing "123" should be greater than string
	 *                   containing "23" as the number 123 greater than number 23
	 */

	static public void sortStringsAsNumbers(String[] strNumbers) {
		int[] lut = new int[1000];
		int temp = 0;

		for (int i = 0; i < strNumbers.length; i++) {
			lut[Integer.valueOf(strNumbers[i])]++; 	// in case if numbering of document
													//is wrong - i sent question is about this line
		}

		for (int i = 0; i < lut.length; i++) {
			if (lut[i] > 0) {
				for (int j = 0; j < lut[i]; j++) {
					strNumbers[temp] = String.valueOf(i);
					temp++;
				}
			}
		}

	}

	// methods for creating array [0...999] for additional test---------------

	public static int[] randomIntArr(int max) {
		int[] ar = new int[max];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (int) (1 + Math.random() * (max - 0 + 1));
		}
		return ar;
	}

	public static String[] intArrToSortedStrArr(int[] unsortedIntArr) {
		String[] sortedStrArr = new String[unsortedIntArr.length];
		Arrays.sort(unsortedIntArr);
		for (int i = 0; i < unsortedIntArr.length; i++) {
			sortedStrArr[i] = String.valueOf(unsortedIntArr[i]);
		}
		return sortedStrArr;
	}

	public static String[] intArrToStrArr(int[] unsortedIntArr) {

		String[] unSortedStrArr = new String[unsortedIntArr.length];
		for (int i = 0; i < unSortedStrArr.length; i++) {
			unSortedStrArr[i] = String.valueOf(unsortedIntArr[i]);
		}
		return unSortedStrArr;
	}
}