import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());

    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i < N; i++) {
	    	int left = N  - i;
	    	int inner = 2 * i - 3;
			for (int j = 0; j < left; j++) {
		    	sb.append(' ');
			}
			sb.append('*');
			if(i >= 2) {
				for (int j = 0; j < inner; j++) {
					sb.append(' ');
				}
				sb.append('*');
			}
			sb.append('\n');
		}
		for (int j = 0; j < 2 * N - 1; j++) {
			sb.append('*');
		}
    	System.out.print(sb.toString());
    }
}
