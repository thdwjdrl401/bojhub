import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int gcd = gcd(A, B);
		System.out.println(gcd);
		System.out.println(A * B / gcd);
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		else if(a == 0) return b;
		else if(a > b) return gcd(a%b, b);
		else return gcd(a, b%a);
	}
}
