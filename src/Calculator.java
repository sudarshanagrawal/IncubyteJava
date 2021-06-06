public class Calculator {
	public static int add(String input) {
		if (input.trim().isEmpty())
			return 0;
		else if (input.length() == 1)
			return Integer.parseInt(input);
		String[] numberSeperated = input.split(",|\n");
		int result = getSum(numberSeperated);
		return result;
	}

	public static int getSum(String[] numbers) {
		int result = 0;
		for (String number : numbers)
			result += Integer.parseInt(number);
		return result;
	}
}