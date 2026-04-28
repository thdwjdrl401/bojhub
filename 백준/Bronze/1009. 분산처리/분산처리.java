import java.util.*;
import java.io.*;

class Main {
	static int T;
	
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = 1;
			for (int i = 0; i < b; i++) {
				result = (result * a - 1) % 10 + 1;
			}
			System.out.println(result);
		}
	}
}