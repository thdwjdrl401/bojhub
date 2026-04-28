import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long facN = 1, facK = 1, facNmaK = 1;
		for (int i = 2; i <= N; i++) {
			facN *= i;
		}
		for (int i = 2; i <= K; i++) {
			facK *= i;
		}
		for (int i = 2; i <= N - K; i++) {
			facNmaK *= i;
		}
		long result = facN / (facK * facNmaK);
		System.out.println(result);
	}

}
