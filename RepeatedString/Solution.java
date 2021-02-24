import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long result = 0;
		int strLength = s.length();
		char[] chArr = s.toCharArray();

		long multipler1 =Math.floorDiv(n, strLength);// strLength
		long multiplier2 = 0;
		for (int i = 0; i < strLength && i<n; i++) {
			char ch = chArr[i];
			if (ch == 'a')
				multiplier2++;
		}
		result = multipler1 * multiplier2;
		long bal = n - strLength * multipler1;
		for (int i = 0; i < bal; i++) {
			char ch = chArr[i];
			if (ch == 'a')
				result++;
		}		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
