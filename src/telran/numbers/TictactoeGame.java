package telran.numbers;

public class TictactoeGame {
	public static void main(String[] args) {
		// place 'x' to [0][0] to win --> diag
		char[][] matrix2 = { { 0, 'x', 'x' },{ 0, 0, 0 },{ 0, 0, 0 } };
		
		System.out.println(tictactoeMove(matrix2, 0, 0, 'x'));

	}



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
		int res = 0;

		matrix = placeSymbol(matrix, nRow, nCol, symb);
		if ( isDraw(matrix) == true) {
			return 2;
		}
		if ( isWin(matrix) == true) {
			return 1;
		}

		return res;
	}

	private static boolean isDraw(char matrix[][]) {
		boolean checkResult = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) { 
				if (matrix[j][i]==0) {
					checkResult = false;
				}
			}
		}
		return checkResult;
	}
	private static boolean isWin(char[][] matrix) {
		boolean checkResult = false;

		int height = matrix.length;
		int length = matrix[0].length;
			
		for (int col = 0; col < length; col++) {
			for (int row = 0; row < length; row++) {

				char checkX = 'x';
				char checkO = 'o';
				if (row <= length - 2) {
					if (checkRow(matrix, row, col, checkX)) {
						checkResult = true;
						break;
					}
					if (checkResult = checkRow(matrix, row, col, checkO)==true) {
						break;
					}
				}
				if (col <= height - 2) {
					if (checkColumn(matrix, row, col, checkX)) {
						checkResult = true;
						break;
					};
					if (checkColumn(matrix, row, col, checkO)) {
						checkResult = true;
						break;
					};
				}
				if (row <= length - 2 && col <= height - 2) {
					if (checkDiagDown(matrix, row, col, checkX)) {
						checkResult = true;
						break;
					}
					if (checkDiagDown(matrix, row, col, checkO)) {
						checkResult = true;
						break;
					}
				}
				if (row <= length - 2 && col >= height + 2) {
					if (checkDiagUp(matrix, row, col, checkX)) {
						checkResult = true;
						break;
					}
					if (checkDiagUp(matrix, row, col, checkO)) {
						checkResult = true;
						break;
					}
				}
			}
		}			
	return checkResult;
	}
	private static boolean checkDiagDown(char[][] matrix , int row, int col, char checkWith) {
		boolean gotIt = false;
		if (matrix[col+1][row+1] == checkWith) {
			if (matrix[col+2][row+2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}
	private static boolean checkDiagUp(char[][] matrix , int row, int col, char checkWith) {
		boolean gotIt = false;
		if (matrix[col-1][row-1] == checkWith) {
			if (matrix[col-2][row-2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}
	private static boolean checkColumn(char[][] matrix , int row, int col, char checkWith) {
		boolean gotIt = false;
		if (matrix[col+1][row] == checkWith) {
			if (matrix[col+2][row] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}
	private static boolean checkRow(char[][] matrix , int row, int col, char checkWith) {
		boolean gotIt = false;
		if (matrix[col][row+1] == checkWith) {
			if (matrix[col][row+2] == checkWith) {
				gotIt = true;
			}
		}
		return gotIt;
	}
	private static char[][] placeSymbol(char matrix[][], int nRow, int nCol, char symb) {

		matrix[nCol][nRow] = symb;

		return matrix;

	}
	
}
