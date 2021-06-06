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

}