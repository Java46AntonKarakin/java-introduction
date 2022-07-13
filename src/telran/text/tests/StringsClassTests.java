package telran.text.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.text.Strings;

class StringsClassTests {

	@Test
	void matchesTest () {
		
//      - David vs. david: match
//      - John F vs. John Fitzgerald: match
//      - John K vs. John Fitzgerald: no match
//      - Anna Maria Magdalena vs. Anna Magdalena: match
//      - Anna Maria Magdalena vs. Maria Magdalena: match
//      - Anna Maria Magdalena vs. Anna Maria Roberta: no match
//      - Anna Maria Magdalena vs. Anna Magdalena Roberta: no match
//      - Anna Maria Magdalena vs. Anna Magdalena Maria: no match
		
		
		String [][] testArray = {
				{"David", "david", "match"},
				{"John F", "John Fitzgerald", "match"},
				{"John K", "John Fitzgerald", "no match"},
				{"Anna Maria Magdalena", "Anna Magdalena", "match"},
				{"Anna Maria Magdalena", "Maria Magdalena", "match"},
				{"Anna Maria Magdalena", "Anna Maria Roberta", "no match"},
				{"Anna Maria Magdalena", "Anna Magdalena Roberta", "no match"},
				{"Anna Maria Magdalena", "Anna Magdalena Maria", "no match"}
				};
		
		for (int i =0; i<testArray.length;i++) {
			assertEquals(testArray[i][2], Strings.matches(testArray[i][0],testArray[i][1]));
		}
	}

	@Test
	void sortStringsAsNumbersTest() {
		String[] randomArr = { "999", "9", "250", "50", "123", "23", "9", "123", "50", "0","999", "0"} ;
		String[] expected = {"0", "0", "9", "9", "23", "50", "50", "123", "123", "250", "999", "999"} ;		
//		assertTrue(Arrays.deepEquals(expected,Strings.sortStringsAsNumbers(randomArr))); // return type of the 
//															1st generation of method sortStringsAsNumbers was String
		
		Strings.sortStringsAsNumbers(randomArr);
		assertArrayEquals(expected,randomArr);

//			 additional test
		
		int [] unsortedRandomArr = Strings.randomIntArr (998);
		String[] randomArr2 = Strings.intArrToStrArr(unsortedRandomArr);
		String[] expected2 = Strings.intArrToSortedStrArr(unsortedRandomArr);
//		assertTrue(Arrays.deepEquals(expected2,Strings.sortStringsAsNumbers(randomArr2))); // return type of the 
// 															1st generation of method sortStringsAsNumbers was String
		
		Strings.sortStringsAsNumbers(randomArr2);
		assertArrayEquals(expected2,randomArr2);
	}

}
