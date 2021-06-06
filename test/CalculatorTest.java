import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void emptyStringTest() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	void StringWithSpacesTest() {
		assertEquals(0, Calculator.add("     "));
	}

	@Test
	void oneValueTest() {
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	void twoValueTest() {
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	void threeValueTest() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	@Test
	void fourValueTest() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}
	@Test
	void fiveValueTest() {
		assertEquals(15, Calculator.add("1,2,3,4,5"));
	}
	@Test
	void sixValueTest() {
		assertEquals(21, Calculator.add("1,2,3,4,5,6"));
	}
	@Test
	void newLineTest() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	void customDelimiterTest() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	@Test
	void customDelimiterTest2() {
		assertEquals(6, Calculator.add("//;\n1\n2;3"));
	}
	@Test
	void negativeNumberTest() {
		try {
			Calculator.add("5,-4");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed -4");
		}
	}
	@Test
	void negativeNumberTest2() {
		try {
		Calculator.add("-1,2,-3");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed -1,-3");
	
	}			
	}
	@Test
	void numberGreaterThanThousandTest() {
		assertEquals(2, Calculator.add("2,1001"));
	}
	@Test
	void customLongDelimiterTest() {
		assertEquals(6, Calculator.add("//[@@]\n1@@2@@3"));
	}
	@Test
	void customMultipleDelimiterTest() {
		assertEquals(6, Calculator.add("//[@][%]\n1@2%3"));
	}
	@Test
	void customMultipleLongDelimiterTest2() {
		assertEquals(6, Calculator.add("//[@@][%%]\n1@@2%%3"));
	}
}