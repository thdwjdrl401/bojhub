import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i = N; i >= 1; i--) {
			dq.push(i);
		}
		int result = 0;
		while(dq.size() > 1) {
			if(dq.size() == 1) {
				result = dq.pop();
				break;
			} else {
				dq.pop();
				dq.offer(dq.pop());				
			}
		}
		if(dq.size() == 1) result = dq.pop();
		System.out.println(result);
	}
}
 