public class Calculator {
	private final static String customDelimiterRegex= "//(.*)\n(.|\n)*";
	private final static String newLine = "\n";
	private final static String defaultDelimiter  = ",";
	public static int add(String input) {
		if (input.trim().isEmpty())
			return 0;
		else if (input.length() == 1)
			return Integer.parseInt(input);
		String delimiter = defaultDelimiter;
		if (input.matches(customDelimiterRegex)) {
			delimiter = Character.toString(input.charAt(2));
			input = input.substring(4);
		}
		String[] numberSeperated = input.split(delimiter + "|" + newLine);
		checkForNegativeNumbers(numberSeperated);
		int result = getSum(numberSeperated);
		return result;
	}

	public static int getSum(String[] numbers) {
		int result = 0;
		for (String number : numbers)
			result += Integer.parseInt(number);
		return result;
	}
	public static void checkForNegativeNumbers(String[] numbers) {
		String negativeNumbers = "";
		for (String number : numbers) {
			if (Integer.parseInt(number) < 0) {
				if (negativeNumbers.trim().isEmpty())
					negativeNumbers += number;
				else
					negativeNumbers += defaultDelimiter + number;
			}
		}
		if (!negativeNumbers.isEmpty())
			throw new IllegalArgumentException("negatives not allowed " + negativeNumbers);
	}
}