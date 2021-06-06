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

}