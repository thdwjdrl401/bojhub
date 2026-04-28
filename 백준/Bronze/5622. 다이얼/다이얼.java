import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[27];
        String s = br.readLine();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			int curint = 0;
			if(cur <= 'R') {
				curint = (cur - 'A') / 3 + 2; 	
			}else {
				if(cur == 'S') curint = 7;
				else if(cur <= 'V') curint = 8;
				else if(cur <= 'Z') curint = 9;
			}
			result += curint + 1;
		}
        System.out.println(result);
	}
}

