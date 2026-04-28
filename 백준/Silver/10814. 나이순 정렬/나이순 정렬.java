import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = br.readLine();
			arr[i][1] = Integer.toString(i);
		}
		Arrays.sort(arr, (a, b) -> {
			String splitA[] = a[0].split(" ");
			String splitB[] = b[0].split(" ");
			int numA = Integer.parseInt(splitA[0]);
			int numB = Integer.parseInt(splitB[0]);
			if(numA != numB) return Integer.compare(numA, numB);
			else {
				return a[1].compareTo(a[1]);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + "\n");
		}
		System.out.println(sb.toString());
	}
}
