import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

   // Complete the isValid function below.
    static String isValid(String s) {
        String result = "YES";
        int[] charCount = new int[26];
        for(char ch : s.toCharArray()) {
            charCount[ch-'a']++;
        }
        Arrays.sort(charCount);
        int i=0;
        while(charCount[i] ==0) {
            i++;
        }
        int min = charCount[i];
        if((charCount[i] == charCount[25]) || (min==1 && charCount[i+1]==charCount[25]))
            return result;
        i++;
        boolean flag = true;
        while(i<26) {
            if(charCount[i] != min) {
                if(flag && charCount[i]-min==1) {
                    flag = false;
                }else {
                    result ="NO";
                    break;
                }
            }
            i++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
