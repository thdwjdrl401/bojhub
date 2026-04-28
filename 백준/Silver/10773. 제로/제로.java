import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < k; i++) {
			int cur = Integer.parseInt(br.readLine());
			if(cur != 0) dq.push(cur);
			else dq.pop();
		}
		int result = 0;
		while(!dq.isEmpty()) {
			result += dq.pop();
		}
		System.out.println(result);
	}
}