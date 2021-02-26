import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int result = 0;
    	for(int i =0;i<s.length();i++) {
    		for(int j=i;j<s.length()-1;j++) {
    			String temp = s.substring(i, j+1);
    			for(int k=i+1;k+temp.length()<=s.length();k++) {
	    			String temp1 = s.substring(k,k+temp.length());
	    			if(isAnagram(temp,temp1)) {
	    				result++;
	    			}
    			}
    		}
    	}
    	return result;
    }
    
    static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] lettermap = new int[26];
        for(int j=0; j<a.length(); j++){
            char ch = a.charAt(j);
            lettermap[ch - 'a']++;
            ch = b.charAt(j);
            lettermap[ch - 'a']--;
        }

        for(int j=0; j<lettermap.length; j++){
            if(lettermap[j] != 0){
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

        }

        scanner.close();
    }
}
