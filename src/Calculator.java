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