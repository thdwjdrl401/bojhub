import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for (int test_case = 0; test_case < T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine().trim());
        	int R = Integer.parseInt(st.nextToken());
        	String S = st.nextToken();
        	StringBuilder sb = new StringBuilder();
        	for (int i = 0; i < S.length(); i++) {
        		for (int j = 0; j < R; j++) {
            		sb.append(S.charAt(i));
				}
			}
        	System.out.println(sb.toString());
		}
    }
}