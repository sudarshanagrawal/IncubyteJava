import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Calculator {
	private final static String customDelimiterRegex = "//(.*)\n((.|\n)*)";
	private final static String newLine = "\n";
	private final static String defaultDelimiter  = ",";
	public static int add(String input) {
		if (input.trim().isEmpty())
			return 0;
		else if (input.length() == 1)
			return Integer.parseInt(input);
		List<String> data = getDelimiter(input);
		String delimiter = data.get(0);
		input = data.get(1);
		String[] numberSeperated = input.split(delimiter + "|" + newLine);
		checkForNegativeNumbers(numberSeperated);
		int result = getSum(numberSeperated);
		return result;
	}

	public static int getSum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			int intNumber = Integer.parseInt(number);
			if (intNumber <= 1000)
				result += intNumber;
		}
		return result;
	}
	public static void checkForNegativeNumbers(String[] numbers) {
		String negativeNumbers = "";
		for (String number : numbers) {
			try {
			if (Integer.parseInt(number) < 0) {
				if (negativeNumbers.trim().isEmpty())
					negativeNumbers += number;
				else
					negativeNumbers += defaultDelimiter + number;
			}
			}			
			catch(Exception e) {continue;}
		}
		if (!negativeNumbers.isEmpty())
			throw new IllegalArgumentException("negatives not allowed " + negativeNumbers);
	}
	public static List<String> getDelimiter(String input) {
		List<String> data = new ArrayList();
		String delimiter = defaultDelimiter;

		if (input.matches(customDelimiterRegex)) {

			String allDelimitersString = null;
			Pattern pattern = Pattern.compile(customDelimiterRegex);
			Matcher matcher = pattern.matcher(input);
			while (matcher.find()) {
				allDelimitersString = matcher.group(1);
				input = matcher.group(2);
			}
			delimiter += "|" + allDelimitersString.replace("[", "").replace("]", "");

		}
		data.add(delimiter);
		data.add(input);
		return data;
	}
}