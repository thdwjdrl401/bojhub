import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	
    	while(A != 0 || B != 0 || C != 0) {
    		int max = Math.max(A, Math.max(B, C));
    		String result = "wrong";
    		if(max == A) {
    			if(A * A == B * B + C * C) result = "right";
    		}else if(max == B) {
    			if(B * B == A * A + C * C) result = "right";
    		}else {
    			if(A * A + B * B == C * C) result = "right";
    		}
    		System.out.println(result);
        	st = new StringTokenizer(br.readLine());
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	C = Integer.parseInt(st.nextToken());
    	}
    }
}