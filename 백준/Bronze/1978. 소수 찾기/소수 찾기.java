import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
    	for (int i = 0; i < N; i++) {
    		if(isPrime(Integer.parseInt(st.nextToken())))count++;
		}
    	System.out.println(count);
    }
    private static boolean isPrime(int n) {
    	if(n <= 1) return false;
    	if(n <= 3) return true;
    	if(n % 2 == 0 || n % 3 == 0) return false;
    	
    	for (int i = 5; i * i <= n; i+= 6) {
			if(n % i == 0 || n % (i + 2) == 0) return false;
		}
    	return true;
    }
}