import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] alphabet = new int[26];
    	String s = br.readLine();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c < 'a') {
    			alphabet[c - 'A']++;
    		}else {
    			alphabet[c - 'a']++;
    		}
    	}
    	int max = 0;
    	int maxIndex = 0;
    	boolean q = false;
    	for (int i = 0; i < alphabet.length; i++) {
			if(max == alphabet[i]) q = true;
			else if(max < alphabet[i]) {
				max = alphabet[i];
				maxIndex = i;
				q = false;
			}
		}
		System.out.println(q ? "?" : (char)(maxIndex + 'A'));
    }
}