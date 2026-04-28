import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        int intS1 = 0;
        int length = 1;
        for (int i = 0; i < s1.length(); i++) {
			intS1 += (s1.charAt(i) - '0') * length;
			length *= 10;
		}
        String s2 = st.nextToken();
        int intS2 = 0;
        length = 1;
        for (int i = 0; i < s2.length(); i++) {
			intS2 += (s2.charAt(i) - '0') * length;
			length *= 10;
		}
        System.out.println(Math.max(intS1, intS2));
        
	}
}
