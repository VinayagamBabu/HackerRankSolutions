import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
    	Stack<Character> data = new Stack<>(); 
    	int result =0;
    	for(int i=0;i<steps;i++) {
    		char letter = path.charAt(i);
    		if(letter == 'D') {
    			if(data.isEmpty()) {
    				result++;
    			}
    			if(!data.isEmpty() && 'U'==data.peek()) {
    				data.pop();
    			}else {
    				data.push('D');
    			}
    		}else {
    			if(!data.isEmpty() && 'D'==data.peek()) {
    				data.pop();
    			}else {
    				data.push('U');
    			}
    		}
    	}
    	return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
