package telran.text;

import java.util.Arrays; // its needed for the second implementation of the method "isAnagram"

public class Strings {
	/**
	 * 
	 * @param str1 ascii string with no repeated symbols
	 * @param str2 ascii string with no repeated symbols
	 * @return array with two numbers first - number of the symbols of the str2 that
	 *         exist in str1 at the same indexes second - number of the symbols of
	 *         the str2 that exist in str1 at different indexes
	 */

	/*
	 * I wrote this method before looking HW's reviews and it seems to be O[N]. 
	 * Is it correct?
	 */

	public static int[] deepNoRepeatedCompare(String str1, String str2) {
		int[] res = { 0, 0 };
		int smallestArrayLength = (str1.length() <= str2.length()) ? str1.length() : str2.length();

		for (int i = 0; i < smallestArrayLength; i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				res[0]++;
				continue;
			}
			if (str1.indexOf(str2.charAt(i)) > -1) {
				res[1]++;
			}
		}
		return res;
	}

	/*------------------------O[N^2] as is-------------------------------*/

//	public static int[] deepNoRepeatedCompare(String str1, String str2) {
//
//		int[] res = { 0, 0 };
//		int str1Length = str1.length();
//		int str2Length = str2.length();
//
//		for (int i = 0; i < str1Length; i++) {
//			for (int j = 0; j < str2Length; j++) {
//				if (str1.charAt(i) == str2.charAt(j)) {
//					if (i == j) {
//						res[0]++;
//					} else {
//						res[1]++;
//					}
//				}
//			}
//		}
//		return res;
//	}

	/**
	 * 
	 * @param str1 English letters (may have repeats)
	 * @param str2 English letters (may have repeats)
	 * @return true if : (1) str2 has the same as str1 length (2) str2 comprises of
	 *         all letters from str1
	 */

	/*
	 * method is written after analyzing HW reviews
	 */

	public static boolean isAnagram(String str1, String str2) {

		return checkQuantity(str1, str2) ? (checkQuality(str1, str2) ? true : false) : false;
	}

	private static boolean checkQuantity(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		return true;
	}

	private static boolean checkQuality(String str1, String str2) {
		int[] matchResultArr = new int[26];
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		for (int i = 0; i < str1.length(); i++) {
			matchResultArr[str1.charAt(i) - 'a']++;
			matchResultArr[str2.charAt(i) - 'a']--;
		}
		return (checkEquality(matchResultArr)) ? true : false;
	}

	private static boolean checkEquality(int[] matchingArr) {
		for (int i = 0; i < matchingArr.length; i++) {
			if (matchingArr[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * My original O[N^2] solution. Unfortunately i didn't know about look-up tables.
	 */

//	public static boolean isAnagram(String str1, String str2) {
//		boolean res = false;
//		
//		if (isLengthEqual(str1, str2) == false) {
//			return res;
//		}
//		
//		char[] arrSorted1 = convertToSorted(str1);
//		char[] arrSorted2 = convertToSorted(str2);
//		
//		res = Arrays.equals(arrSorted1, arrSorted2);
//		
//		return res;
//	}
//
//	private static char[] convertToSorted(String str) {
//		char[] res = str.toCharArray();
//		Arrays.sort(res);
//		return res;
//	}
//
//	private static boolean isLengthEqual(String str1, String str2) {
//		boolean res = true;
//		if (str1.length() != str2.length()) {
//			res = false;
//		}
//		return res;
//	}
}
