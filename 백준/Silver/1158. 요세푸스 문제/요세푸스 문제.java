import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	LinkedList<Integer> ll = new LinkedList<>();
    	for(int i = 1; i <= N; i++) ll.add(i);
    	int index = 0;
    	StringBuilder sb = new StringBuilder();
    	sb.append("<");
    	for(int i = 0; i < N; i++) {
    		index += K;
    		index %= N - i;
    		if(index == 0) index = N - i;

    		int cur = ll.get(index-1);
    		ll.remove(index-1);
    		index--;
    		if(i != N - 1) sb.append(cur + ", ");
    		else sb.append(cur + ">");
    	}
    	System.out.println(sb.toString());
    		
    }
}
