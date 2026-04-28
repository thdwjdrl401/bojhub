import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] reserve;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        N = Integer.parseInt(br.readLine());
        reserve = new int[N][2];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());	
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	reserve[i][0] = start;
        	reserve[i][1] = end;
		}
        Arrays.sort(reserve, (a, b)->{
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int preEnd = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
        	int curStart = reserve[i][0];
        	int curEnd = reserve[i][1];
			if(preEnd <= curStart) {
				preEnd = curEnd;
				result ++;
			}
		}
        
        System.out.println(result);
    }
}
