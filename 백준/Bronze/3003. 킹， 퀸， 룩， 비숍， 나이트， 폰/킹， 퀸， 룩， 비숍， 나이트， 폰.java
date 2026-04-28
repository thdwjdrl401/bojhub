import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[] {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
			arr[i] -= Integer.parseInt(st.nextToken());
		}
        for (int i = 0; i < 6; i++) {
			sb.append(arr[i]).append(" ");
		}
        System.out.println(sb);
	}
}