import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'primality' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */

    public static String primality(int n) {
    // Write your code here
     if (n < 2) {
        return "Not prime";
    }
    if(n == 2){
        return "Prime";
    }
    if (n%2 ==0) {
        return "Not prime";
    }
    int sqrt = (int)Math.sqrt(n);
    for (int i = 3; i <= sqrt; i = i + 2) {
        if (n % i == 0) {
            return "Not prime";
        }
    }
    return "Prime";
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, p).forEach(pItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String result = Result.primality(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
