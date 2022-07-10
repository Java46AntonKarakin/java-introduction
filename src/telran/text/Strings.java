package telran.text;

import java.util.Arrays;

public class Strings {
	/**
	 * 
	 * @param str1 ascii string with no repeated symbols
	 * @param str2 ascii string with no repeated symbols
	 * @return array with two numbers first - number of the symbols of the str2 that
	 *         exist in str1 at the same indexes second - number of the symbols of
	 *         the str2 that exist in str1 at different indexes
	 */

	public static int[] deepNoRepeatedCompare(String str1, String str2) {
		int[] res = { 0, 0 };
		if (str1.length() <= str2.length()) {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					res[0]++;
					continue;
				}
				if (str1.indexOf(str2.charAt(i)) > -1) {
					res[1]++;
				}
			}
		}
		if (str1.length() > str2.length()) {
			for (int i = 0; i < str2.length(); i++) {
				char str1Char = str1.charAt(i);
				char str2Char = str2.charAt(i);
				if (str1Char == str2Char) {
					res[0]++;
					continue;
				}
				if (str1.indexOf(str2Char) > -1) {
					res[1]++;
				}
			}
		}

		return res;
	}

//	public static int[] deepNoRepeatedCompare(String str1, String str2) {
//		int[] res = {0, 0};
//		
//		char[] charArray1 = str1.toCharArray();
//		char[] charArray2 = str2.toCharArray();
//
//		for (int i = 0; i < charArray1.length; i++) {
//			for (int j = 0; j < charArray2.length; j++) {
//				if (charArray1[i] == charArray2[j]) {
//					if (i == j) {
//						res [0]++;
//					} else {
//						res [1]++;
//					}
//				}
//			}
//		}
// 		
//		return res;
//	}

	/**
	 * 
	 * @param str1 English letters (may have repeats)
	 * @param str2 English letters (may have repeats)
	 * @return true if : (1) str2 has the same as str1 length (2) str2 comprises of
	 *         all letters from str1
	 */
	
	
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		// 1) is the length equal? if TRUE - continue
		if (isLengthEqual(str1, str2)==false) {
			return res;
		}
		
/*---------2) str1 & str2 to sorted arrays of symbols---------*/
		char [] arrSorted1 = convertToSorted(str1);
		char [] arrSorted2 = convertToSorted(str2);
/*---------3) compare str1Convrted and str2Convrted---------*/
		res = Arrays.equals(arrSorted1, arrSorted2);
		
		return res;
	}

	private static char [] convertToSorted(String str) {
		char [] res = str.toCharArray();
		Arrays.sort(res);
		return res;
	}

	private static boolean isLengthEqual(String str1, String str2) {
		boolean res = true;
		if (str1.length() != str2.length()) {
			res = false;
		}
		return res;
	}
}
