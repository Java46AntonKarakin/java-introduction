package telran.numbers;

import java.util.Arrays;

/**
 * 
 * @author User application should print out 7 random numbers in the range
 *         [1-49]
 */

public class SportLotoAppl {
	public static final int minValue = 1;
	public static final int maxValue = 49;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(SportLoto()));
	}

	private static int[] SportLoto() {

		// creates random array

		int[] res = new int[7];
		for (int i = 0; i < res.length; i++) {
			res[i] = getRandomNumber(minValue, maxValue);
		}

		// checking random array if there are any repeated meanings

		for (int i = 0; i < res.length; i++) {
			for (int j = i + 1; j < res.length; j++) {
				if (res[i] == res[j]) {
					res[j] = getRandomNumber(minValue, maxValue);
					i = 0;
					j = 1;
				}
			}
		}
		return res;
	}

	// helper method for getting one random number in the range [min-max]

	private static int getRandomNumber(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}
