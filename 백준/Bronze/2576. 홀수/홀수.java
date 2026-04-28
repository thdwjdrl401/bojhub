import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int test_case = 0; test_case < 7; test_case++) {
        	int curN = Integer.parseInt(br.readLine());
        	if(curN % 2 == 1) {
        		sum += curN;
        		min = Math.min(min, curN);
        	}
        }
        if(sum == 0) System.out.println(-1);
        else {
        	System.out.println(sum);
            System.out.println(min);	
        }
    }
}