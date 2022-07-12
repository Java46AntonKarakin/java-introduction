package telran.text;

public class Strings {
	static public String join(String[] array, String delimiter) {
		// STring "+" operator based solution
		return stringPluseSolution(array, delimiter);
		// StringBuilder attend based solution
		// return stringBuilderSolution(array, delimiter);
	}

	static private String stringBuilderSolution(String[] array, String delimiter) {
		StringBuilder strBuilder = new StringBuilder(array[0]);
		for (int i = 1; i < array.length; i++) {
			strBuilder.append(delimiter).append(array[i]);
		}
		return strBuilder.toString();
	}

	static private String stringPluseSolution(String[] array, String delimiter) {
		String res = array[0]; // assumption: there is at least one string
		for (int i = 1; i < array.length; i++) {
			res += delimiter + array[i];
		}
		return res;
	}

	/**
	 * 
	 * @param name1 - first name
	 * @param name2 - second name
	 * @return either "match" or "no match" in accordance to the comments (see TODO)
	 */
	public static String matches(String name1, String name2) {

		name1 = name1.trim().toUpperCase();
		name2 = name2.trim().toUpperCase();

		if (name1.equals(name2)) {
			return "match";
		}
		String[] arrName1 = name1.split(" ");
		String[] arrName2 = name2.split(" ");

		if (arrName1.length == arrName2.length) {

			int positionOfAbbr = isAbbreviation(arrName1);

			if (positionOfAbbr >= 0) {
				if (isAbbrMatch(arrName1, arrName2, positionOfAbbr)) {
					return "match";
				}
				return "no match";
			}
		}
		if (arrName1.length > arrName2.length) {
			if (isSecondEqualsThird(arrName1, arrName2)) {
				return "match";
			}
		}
		return "no match";
	}

	private static boolean isSecondEqualsThird(String[] arrName1, String[] arrName2) {
		for (int i = 0; i < arrName1.length - 1; i++) {
			if (arrName1[i].equals(arrName2[0])) {
				return true;
			}
		}
		return false;
	}

	private static boolean isAbbrMatch(String[] arrName1, String[] arrName2, int positionOfAbbr) {
		for (int i = 0; i < arrName2.length; i++) {
			if (arrName2[i].startsWith(arrName1[positionOfAbbr])) {
				return true;
			}
		}
		return false;
	}

	private static int isAbbreviation(String[] arrName1) {
		int res = -1;
		for (int i = 0; i < arrName1.length; i++) {
			if (arrName1[i].length() == 1) {
				res = i;
			}
		}
		return res;
	}

	/**
	 * sorts array of strings
	 * 
	 * @param strNumbers array of strings containing the positive integer numbers
	 *                   length of each string can not be more than three symbols
	 *                   String containing "123" should be greater than string
	 *                   containing "23" as the number 123 greater than number 23
	 */
	static public String[] sortStringsAsNumbers(String[] strNumbers) {
		int[] countArr = new int[1000];
		int temp = 0;

		for (int i = 0; i < strNumbers.length; i++) {
			countArr[Integer.valueOf(strNumbers[i])]++;
		}

		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] > 0) {
				for (int j = 0; j < countArr[i]; j++) {
					strNumbers[temp] = String.valueOf(i);
					temp++;
				}
			}
		}
		return strNumbers;
	}
	
	public static String[] randomArr(int max) {
		String[] ar = new String[max];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = String.valueOf((int) (1 + Math.random() * (max - 0 + 1)));
		}
		return ar;
	}

	/*----------old stuff below---------- */
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

	public static int[] deepNoRepeatedCompareOld(String str1, String str2) {

		int[] res = { 0, 0 };
		int str1Length = str1.length();
		int str2Length = str2.length();

		for (int i = 0; i < str1Length; i++) {
			for (int j = 0; j < str2Length; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == j) {
						res[0]++;
					} else {
						res[1]++;
					}
				}
			}
		}
		return res;
	}

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
}