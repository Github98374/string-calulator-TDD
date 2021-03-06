package com.tdd.calculator;

public class Calculator {

	// Method for testing our method for desired output

//	public static void main(String args[]) {
//		System.out.println("result: " + add("1001,9"));
//	}

//		main method for performing addition of passed arguments
	public static int add(String text) {
//			retrun 0 if arguments are null or empty
		if (text.equals("") || text.isEmpty() || text == "") {
			return 0;
		} else {
			String delimiter = ",";
			if (text.matches("//(.*)\n(.*)")) {
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}

			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList);
		}
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider) {
		return numbers.split(divider);
	}

	private static int sum(String[] numbers) {
		int total = 0;
		String negString = "";

		for (String number : numbers) {
			if (toInt(number) < 0) {
				if (negString.equals(""))
					negString = number;
				else
					negString += ("," + number);
			}
			if (toInt(number) < 1000)
				total += toInt(number);
		}

		if (!negString.equals("")) {
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
	}
}
