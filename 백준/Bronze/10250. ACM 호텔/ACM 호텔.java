import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for (int test_case = 0; test_case < T; test_case++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int H = Integer.parseInt(st.nextToken());
        	int W = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	int floor, room;
        	
        	int n = N - 1;
        	floor = n % H + 1;
        	room = n / H + 1;
        	StringBuilder sb = new StringBuilder();
        	sb.append(floor);
        	if(room / 10 == 0) sb.append(0);
        	sb.append(room);
        	System.out.println(sb.toString());
		}
    }
}