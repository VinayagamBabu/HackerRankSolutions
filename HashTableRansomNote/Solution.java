import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		int count = 0;
		Arrays.sort(magazine);
		Arrays.sort(note);
		for (int i = 0,j=0; i < magazine.length && j <note.length; ) {
			if(note[j].compareTo(magazine[i]) >= 1) {
				i++;
			}else if(note[j].equals(magazine[i])) {
				magazine[i] = null;
				count++;
				i++;
				j++;
			}else {
				break;
			}
		}
		if (count == note.length)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
