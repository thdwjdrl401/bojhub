import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String S = br.readLine();
    	int[] alphabet = new int[26];
    	Arrays.fill(alphabet, -1);
    	for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(alphabet[c - 'a'] == -1) alphabet[c - 'a'] = i;
		}
    	for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
    }
}