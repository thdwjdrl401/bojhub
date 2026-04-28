import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int count = 0;
    	for (int i = 0; i < N; i++) {
    		String s = br.readLine();
    		char preC = s.charAt(0);
    		boolean isGroup = true;
        	boolean[] arr = new boolean[26];
    		for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(arr[c - 'a']) {
					isGroup = false;
					break;
				}
				if(preC != c) {
					arr[preC - 'a'] = true;
					preC = c;
				}
			}
    		if(isGroup) count++;
		}
    	System.out.println(count);
    }
}
