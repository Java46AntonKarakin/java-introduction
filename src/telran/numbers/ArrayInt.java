package telran.numbers;

import java.util.Arrays;

public class ArrayInt {

	public static int[] addNumber(int ar[], int number) {
		int[] res = Arrays.copyOf(ar, ar.length + 1);
		res[res.length - 1] = number;
		return res;
	}

	/**
	 * 
	 * @param ar
	 * @param index
	 * @param number
	 * @return new array containing number value at the given index
	 */

	public static int[] insertNumber(int ar[], int index, int number) {
		int[] res = Arrays.copyOf(ar, ar.length + 1);
		System.arraycopy(ar, index, res, index + 1, ar.length - index);
		res[index] = number;
		return res;
		// solution should be based on the method arraycopy of the class System
		// (System.arraycopy)
	}

	/**
	 * 
	 * @param ar
	 * @param index
	 * @return new array with removed number at the given index
	 */
	public static int[] removeNumber(int ar[], int index) {

		int[] localArr = new int[ar.length - 1];

		if (index == 0) {
			System.arraycopy(ar, 1, localArr, 0, ar.length - 1);
		}

		if (index != 0 && index > 0 && index != ar.length - 1) {
			System.arraycopy(ar, 0, localArr, 0, index);
			System.out.println("localArr = " + Arrays.toString(localArr));
			System.arraycopy(ar, index + 1, localArr, index, ar.length - 2);
		}

		if (index == ar.length - 1) {
			System.arraycopy(ar, 0, localArr, 0, ar.length - 1);
		}

		if (index == 0) {
			System.arraycopy(ar, 1, localArr, 0, ar.length - 1);
		}
		System.out.println();

		return localArr;

		// solution should be based on the method arraycopy of the class System
		// (System.arraycopy)
	}

	/**
	 * 
	 * @param ar
	 * @param number
	 * @return if the given number exists in the given array then returns the index
	 *         of first occurrence, otherwise returns -1
	 */
	public static int indexOf(int ar[], int number) {
		int res = -1;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == number) {
				res = i;
				break;
			}
		}
		return res;
	}
}
