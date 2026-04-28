import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Deque<Integer> dq = new ArrayDeque<>();
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String cmd = st.nextToken();
    		if(cmd.equals("push")) dq.push(Integer.parseInt(st.nextToken()));
    		else if(cmd.equals("pop")) {
    			sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append('\n');
    		} else if(cmd.equals("size")) {
    			sb.append(dq.size()).append('\n');
    		} else if(cmd.equals("empty")) {
    			sb.append(dq.isEmpty() ? 1 : 0).append('\n');
    		} else if(cmd.equals("front")) {
    			sb.append(dq.isEmpty() ? -1 : dq.getLast()).append('\n');
    		} else if(cmd.equals("back")) {
    			sb.append(dq.isEmpty() ? -1 : dq.getFirst()).append('\n');
    		}
		}
    	System.out.println(sb.toString());
	}
}