import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'stepPerms' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    
    static int[] result = new int[100000];
    
    public static int stepPerms(int n) {
    // Write your code here
        if(result[n] != 0) {
            return result[n];
        }else {
            result[n]= stepPerms(n-3)+stepPerms(n-2)+stepPerms(n-1);
            return result[n];
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result.result[0] = 0;
        Result.result[1] = 1;
        Result.result[2] = 2;
        Result.result[3] = 4;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, s).forEach(sItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int res = Result.stepPerms(n);

                bufferedWriter.write(String.valueOf(res));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
