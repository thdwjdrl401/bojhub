import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] natural = new boolean[1000001];
		boolean[] reverse = new boolean[1000001];
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x >= 0) natural[x] = true;
			else reverse[-x] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1000000; i > 0; i--) {
			if(reverse[i])sb.append("-"+i).append("\n");
		}
		for (int i = 0; i <= 1000000; i++) {
			if(natural[i])sb.append(i).append("\n");
		}
		System.out.print(sb.toString());
	}
}
