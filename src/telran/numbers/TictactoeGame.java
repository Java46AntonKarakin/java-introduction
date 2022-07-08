package telran.numbers;

public class TictactoeGame {

	/**
	 * 
	 * @param matrix square matrix (nRows == nColumns; where nRows >= 3)
	 * @param nRow   (number of row)
	 * @param nCol   (number of column)
	 * @param symb   (being filled symbol either 'x' or '0')
	 * @return 0 - game isn't over; 1 - game is over with the winner's move; 2 -
	 *         game is over with draw
	 */

	public static int tictactoeMove(char matrix[][], int nRow, int nCol, char symb) {

		matrix = placeSymbol(matrix, nRow, nCol, symb);

		return isDraw(matrix) ? 2 : isWin(matrix, symb) ? 1 : 0;
	}

	private static boolean isWin(char[][] matrix, char symb) {
		boolean checkResult = false;
		if (symb == 'x') {
			checkResult = isGameFinishedByX(matrix, symb);

		}
		if (symb == 'o') {
			checkResult = isGameFinishedByO(matrix, symb);
		}

		return checkResult;
	}

	private static boolean isGameFinishedByX(char[][] matrix, char symb) {
		boolean checkResult = false;
		int side = matrix.length;

		OUTTERFOR: for (int col = 0; col < side; col++) {
			for (int row = 0; row < side; row++) {

				if (row <= side - 3 && matrix[col][row] == symb) {
					if (checkRow(matrix, col, row, 'x')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
				if (col <= side - 3 && matrix[col][row] == symb) {
					if (checkColumn(matrix, col, row, 'x')) {
						checkResult = true;
						break OUTTERFOR;
					}
					;
				}
				if (col <= side - 3 && row <= side - 3 && matrix[col][row] == symb) {
					if (checkDiagDown(matrix, col, row, 'x')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
				if (col >= 2 && row <= side - 3 && matrix[col][row] == symb) {
					if (checkDiagUp(matrix, col, row, 'x')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
			}
		}
		return checkResult;
	}

	private static boolean isGameFinishedByO(char[][] matrix, char symb) {
		boolean checkResult = false;
		int side = matrix.length;

		OUTTERFOR: for (int col = 0; col < side; col++) {
			for (int row = 0; row < side; row++) {

				if (row <= side - 3 && matrix[col][row] == symb) {
					if (checkRow(matrix, col, row, 'o')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
				if (col <= side - 3 && matrix[col][row] == symb) {
					if (checkColumn(matrix, col, row, 'o')) {
						checkResult = true;
						break OUTTERFOR;
					}
					;
				}
				if (col <= side - 3 && row <= side - 3 && matrix[col][row] == symb) {
					if (checkDiagDown(matrix, col, row, 'o')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
				if (col >= 2 && row <= side - 3 && matrix[col][row] == symb) {
					if (checkDiagUp(matrix, col, row, 'o')) {
						checkResult = true;
						break OUTTERFOR;
					}
				}
			}
		}
		return checkResult;
	}

	private static boolean isDraw(char matrix[][]) {
		boolean checkResult = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][i] == 0) {
					checkResult = false;
				}
			}
		}
		return checkResult;
	}

	private static boolean checkDiagDown(char[][] matrix, int col, int row, char checkWith) {
		boolean gotIt = false;
		if (matrix[col + 1][row + 1] == checkWith) {
			if (matrix[col + 2][row + 2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}

	private static boolean checkDiagUp(char[][] matrix, int col, int row, char checkWith) {
		boolean gotIt = false;
		if (matrix[col - 1][row + 1] == checkWith) {
			if (matrix[col - 2][row + 2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}

	private static boolean checkColumn(char[][] matrix, int col, int row, char checkWith) {
		boolean gotIt = false;
		if (matrix[col + 1][row] == checkWith) {
			if (matrix[col + 2][row] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}

	private static boolean checkRow(char[][] matrix, int col, int row, char checkWith) {
		boolean gotIt = false;
		if (matrix[col][row + 1] == checkWith) {
			if (matrix[col][row + 2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}

	private static char[][] placeSymbol(char matrix[][], int Col, int Row, char symb) {

		matrix[Col][Row] = symb;

		return matrix;

	}
}
