import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int M = Integer.parseInt(br.readLine());
    	Set<Integer> set = new HashSet<>();
    	StringBuilder sb = new StringBuilder();
    	Set<Integer> allSet = new HashSet<>();
    	for (int i = 1; i <= 20; i++) {
			allSet.add(i);
		}
    	for (int i = 0; i < M; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("check")) {
				sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n');
			}else if(cmd.equals("toggle")) {
				int cur = Integer.parseInt(st.nextToken());
				if(set.contains(cur)) set.remove(cur);
				else set.add(cur);
			}else if(cmd.equals("all")) {
				set.clear();
				set.addAll(allSet);
			}else if(cmd.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb.toString());
    }
}