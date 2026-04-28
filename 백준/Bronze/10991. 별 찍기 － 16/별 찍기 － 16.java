import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());

    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i <= N; i++) {
	    	int left = N  - i;
			for (int j = 0; j < left; j++) {
		    	sb.append(' ');
			}
			sb.append('*');
			for (int j = 1; j < i; j++) {
				sb.append(' ');
				sb.append('*');
			}
			sb.append('\n');
		}
    	System.out.print(sb.toString());
    }
}