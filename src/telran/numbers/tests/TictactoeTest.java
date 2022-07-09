package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.TictactoeGame;

public class TictactoeTest {

	@Test
	public void testTictactoeMove() {


		
		// place 'x' to [0][0] to wins --> diag up
		char[][] matrixD1 = { 
				{ 0, 0, 0 },
				{ 0, 'x', 0 },
				{ 0, 0, 'x' }
				};
		// place 'x' to [0][2] to wins --> diag down
		char[][] matrixD2 = { 
				{ 0, 0, 0 },
				{ 0, 'x', 0 },
				{ 'x', 0, 0 }
		};

		// place 'x' to [0][0] to wins --> row
		char[][] matrixR1 = { 
				{ 0, 'x', 'x' },
				{ 0, 0, 0 },
				{ 0, 0, 0 } 
				};
		// place 'x' to [1][1] to wins --> row
		char[][] matrixR2 = { 
				{ 0, 0, 0 },
				{'x', 0, 'x'},
				{ 0, 0, 0 } 
		};
		// place 'x' to [2][2] to wins --> row
		char[][] matrixR3 = { 
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 'x', 'x', 0 } 
		};
		// place 'x' to [0][0] to wins --> column
		char[][] matrixC1 = { 
				{ 0, 0, 0 },
				{ 'x', 0, 0 },
				{ 'x', 0, 0 }
		};
		// place 'x' to [1][1] to wins --> column
		char[][] matrixC2 = { 
				{ 0, 'x', 0 },
				{ 0, 0, 0 },
				{ 0, 'x', 0 }
		};
		// place 'x' to [2][2] to wins --> column
		char[][] matrixC3 = { 
				{ 0, 0, 'x' },
				{ 0, 0, 'x' },
				{ 0, 0, 0 }
		};

		// place 'x' to [0][0] to draw
		char[][] matrix4 = { 
				{ 0, 'x', 'o' },
				{ 'o', 'x', 'x' },
				{ 'x', 'o', 'o' }
				};

		// game is not complete
		char[][] matrix5 = { 
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 } 
				};
		
		// place 'x' to [1][0] to game is not complete 
		char[][] matrix6 = { 
				{ 0, 0, 0 },
				{ 0, 'x', 0 },
				{ 0, 0, 'x' } };

		int gameIsNotComplete = 0;
		int smbWins = 1;
		int draw = 2;

		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixD1, 0, 0, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixD2, 0, 2, 'x'));
		
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixR1, 0, 0, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixR2, 1, 1, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixR3, 2, 2, 'x'));
				
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixC1, 0, 0, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixC2, 1, 1, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrixC3, 2, 2, 'x'));
		
		assertEquals(draw, TictactoeGame.tictactoeMove(matrix4, 0, 0, 'x'));
		assertEquals(gameIsNotComplete, TictactoeGame.tictactoeMove(matrix5, 0, 0, 'x'));
		assertEquals(gameIsNotComplete, TictactoeGame.tictactoeMove(matrix6, 1, 0, 'x'));

	}

}
