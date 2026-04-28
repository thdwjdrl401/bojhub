import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int test_case = 0; test_case < N; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int x = Integer.parseInt(st.nextToken());	
				dq.push(x);
			} else if(cmd.equals("pop")) {
				if(!dq.isEmpty()) System.out.println(dq.pop());
				else System.out.println("-1");
			} else if(cmd.equals("size")) {
				System.out.println(dq.size());
			} else if(cmd.equals("empty")) {
				int isEmpty = dq.isEmpty() ? 1 : 0;
				System.out.println(isEmpty);
			} else {
				int top = dq.peek() != null ? dq.peek() : -1;
				System.out.println(top);
			}
		}
	}
}