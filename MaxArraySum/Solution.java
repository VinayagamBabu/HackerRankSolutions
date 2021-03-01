import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0] > 0 ? arr[0]:0;
        int i =0;
        for(i=1;i < arr.length;i++) {
            if(i == 1) {
                max[i] = arr[i] > max[0] ? arr[i] :max[0];
            }else {
            	max[i] = arr[i]+ max[i-2] > max[i-1] ? arr[i]+ max[i-2] : max[i-1];
            	if(arr[i] > max[i])
            		max[i] = arr[i];
            }
        }
        return max[i-1];
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
