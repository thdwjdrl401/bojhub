import java.io.*;
import java.util.*;

public class Main {
    
	static int N, r, c;
	static int size;

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        size = 1<<N;
        
        dfs(0, 0, 0, size * size - 1, size);
    }
    
    static void dfs(int sr, int sc, int start, int end, int n) {
    	if(n == 2) {
    		int result = start;
    		if(r != sr) result += 2;
    		if(c != sc) result++;
    		System.out.println(result);
    		return;
    	}
    	if(r < sr + n / 2) {
    		if(c < sc + n / 2) dfs(sr, sc, start, start + (end-start + 1) / 4 - 1, n / 2);
    		else dfs(sr, sc + n / 2, start + (end-start + 1) / 4, start + (end-start + 1) / 2 - 1, n / 2);
    	}else {
    		if(c < sc + n / 2) dfs(sr + n / 2, sc, start + (end-start + 1) / 2, start + (end-start + 1) / 4 * 3 - 1, n / 2);
    		else dfs(sr + n / 2, sc + n / 2, start + (end-start + 1) / 4 * 3, end, n / 2);
    	}
    }
}