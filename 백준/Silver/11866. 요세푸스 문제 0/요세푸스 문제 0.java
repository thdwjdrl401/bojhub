import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	List<Integer> list = new LinkedList<>();
    	
    	for(int i = 1; i <= N; i++) list.add(i);
    	int index = 0;
    	StringBuilder sb = new StringBuilder();
    	sb.append('<');
    	while(list.size() > 0) {
    		int size = list.size();
    		index += K - 1;
    		index %= size;
    		sb.append(list.get(index)).append(", ");
    		list.remove(index);
    	}
    	sb.deleteCharAt(sb.length() - 1);
    	sb.setCharAt(sb.length() - 1, '>');
    	System.out.println(sb.toString());
	}
}