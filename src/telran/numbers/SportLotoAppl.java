package telran.numbers;

import java.util.Arrays;

/**
 * 
 * @author User application should print out 7 random numbers in the range
 *         [1-49]
 */

public class SportLotoAppl {
	public static final int maxValue = 49;
	public static final int minValue = 1;

	public static void main(String[] args) {
		System.out.println(Arrays.toString(SportLoto()));
	}

	private static int[] SportLoto() {
													// 	creates rundom array
		int[] res = new int[7];
		for (int i = 0; i < res.length;) { 									
			int tempRandomNumber = getRandomNumber(minValue, maxValue);
			if (res[i] != tempRandomNumber) {
				res[i] = tempRandomNumber;
				i++;
			}
		}		
													// checking random array if there is any repeated meanings		
		
		for (int j = 0; j < res.length - 1; j++) {			
			for (int i = j + 1; i < res.length;i++) {
				if (res[i] == res[j]) {
					res[i] = getRandomNumber(minValue, maxValue);
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
