import java.util.*;
import java.io.*;

public class Main {

	static int N;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < 2 * N; i++) {
    		for (int j = 0; j < 2 * N - i - 1; j++) {
    			sb.append(" ");
			}
    		sb.append('*');
    		if(i < N) {
    			for (int j = 0; j < N; j++) {
    				sb.append(" ");
    			}
    			sb.append('*');
    			for (int j = 0; j < i * 2 + 1; j++) {
    				sb.append(" ");
				}
    			sb.append('*');
    			for (int j = 0; j < N - i - 1; j++) {
    				sb.append(" ");
				}
    		} else {
    			for (int j = 0; j < N + (i - N) * 2 + 1 ; j++) {
    				sb.append(" ");
    			}
    			sb.append('*');
    			for (int j = 0; j < 2 * N - 1 - 2 * (i - N); j++) {
    				sb.append(" ");
				}
    			sb.append('*');
    			for (int j = 0; j < i - N; j++) {
    				sb.append(" ");
				}
    		}
    		
    		
    		
    		sb.append('\n');
		}
    	System.out.println(sb);
    }
}