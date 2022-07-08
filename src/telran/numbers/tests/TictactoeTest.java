package telran.numbers.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.numbers.TictactoeGame;

public class TictactoeTest {

	@Test
	public void testTictactoeMove() {


		
		// place 'x' to [0][0] to wins --> diag
		char[][] matrix1 = { { 0, 0, 0 },{ 0, 'x', 0 },{ 0, 0, 'x' } };

		// place 'x' to [0][0] to wins --> row
		char[][] matrix2 = { { 0, 'x', 'x' },{ 0, 0, 0 },{ 0, 0, 0 } };

		// place 'x' to [0][0] to wins --> column
		char[][] matrix3 = { { 0, 0, 0 },{ 'x', 0, 0 },{ 'x', 0, 0 } };

		// place 'x' to [0][0] to draw
		char[][] matrix4 = { { 0, 'x', 'o' },{ 'o', 'x', 'x' },{ 'x', 'o', 'o' } };

		// game is not complete
		char[][] matrix5 = { { 0, 0, 0 },{ 0, 0, 0 },{ 0, 0, 0 } };
		
		// place 'x' to [1][0] to game is not complete 
		char[][] matrix6 = { { 0, 0, 0 },{ 0, 'x', 0 },{ 0, 0, 'x' } };

		int gameIsNotComplete = 0;
		int smbWins = 1;
		int draw = 2;

		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrix1, 0, 0, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrix2, 0, 0, 'x'));
		assertEquals(smbWins, TictactoeGame.tictactoeMove(matrix3, 0, 0, 'x'));
		assertEquals(draw, TictactoeGame.tictactoeMove(matrix4, 0, 0, 'x'));
		assertEquals(gameIsNotComplete, TictactoeGame.tictactoeMove(matrix5, 0, 0, 'x'));
		assertEquals(gameIsNotComplete, TictactoeGame.tictactoeMove(matrix6, 1, 0, 'x'));

	}

}
