package br.carlosandre.main;
public class Problem1 {

	private static final int TARGET = 500;
	public static String newline = System.getProperty("line.separator");

	public static void main(String args[]) {
		long number;
		StringBuilder sb = new StringBuilder();

		for (long i = 1; i <= Integer.MAX_VALUE; i++) {
			number = sequence(i);
			sb.append(i + "! = " + number + newline);

			if (i == TARGET) {
				System.out.println("The first number in the sequence to have more than 500 divisors is: " + number);
				System.out.println(newline + "Here is the list: " + newline + sb.toString());
				break;
			}
		}
	}

	public static long sequence(long num) {
		if (num <= 1)
			return 1;
		else
			return num + sequence(num - 1);
	}
}