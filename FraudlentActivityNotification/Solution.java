import java.io.IOException;
import java.util.Scanner;

public class Solution {

	 static int activityNotifications(int[] expenditure, int d) {;

     int notificationCount = 0;

     int[] count = new int[201];
     //adding data only for first set of d values.
     for (int i = 0; i < d; i++) {
    	 count[expenditure[i]]++;
     }

     for (int i = d; i < expenditure.length; i++) {

         double median = getMedian(d, count); // get median using counting sort Algorithm

         if (expenditure[i] >= 2 * median) {
             notificationCount++;

         }
         //removing old value from count array and adding new value into array
         count[expenditure[i]]++;
         count[expenditure[i - d]]--;

     }

     return notificationCount;

 }

 private static double getMedian(int d, int[] data) {
     double median = 0;
     if (d % 2 == 0) {
         Integer m1 = null;
         Integer m2 = null;
         int count = 0;
         for (int j = 0; j < data.length; j++) {
             count += data[j];
             if (m1 == null && count >= d/2) {
                 m1 = j;
             }
             if (m2 == null && count >= d/2 + 1) {
                 m2 = j;
                 break;
             }
         }
         median = (m1 + m2) / 2.0;
     } else {
         int count = 0;
         for (int j = 0; j < data.length; j++) {
             count += data[j];
             if (count > d/2) {
                 median = j;
                 break;
             }
         }
     }
     return median;
 }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        scanner.close();
    }
}
