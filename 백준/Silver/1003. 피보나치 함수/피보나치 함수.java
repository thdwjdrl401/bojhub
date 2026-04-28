import java.io.*;
import java.util.*;

public class Main {

	static List<int[]> result = new ArrayList<>();
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	result.add(new int[]{1, 0});
    	result.add(new int[]{0, 1});
    	for (int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		fibonacci(N);    			
    		System.out.println(result.get(N)[0] + " " + result.get(N)[1]);
		}
    }
    
    private static void fibonacci(int n) {
        if (result.size() <= n) {
            fibonacci(n - 1);
        	result.add(new int [] {result.get(n - 1)[0] + result.get(n - 2)[0], result.get(n - 1)[1] + result.get(n - 2)[1]});
        }
    }
}