import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		int[] alphabetA = new int[26];
		int[] alphabetB = new int[26];
		int sameCount = 0;
		for(int i = 0; i < A.length(); i++) alphabetA[A.charAt(i) - 'a']++;
		for(int i = 0; i < B.length(); i++) alphabetB[B.charAt(i) - 'a']++;
		for(int i = 0; i < 26; i++) {
			sameCount += Math.min(alphabetA[i], alphabetB[i]); 
		}
		int result = A.length() + B.length() - 2 * sameCount;
		System.out.println(result);
	}
}
