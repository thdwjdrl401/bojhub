import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] trees;
	static int maxTree = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(maxTree < trees[i]) maxTree = trees[i];
		}
        System.out.println(bs());
        
    }
    static int bs() {
    	int lo = 0;
    	int hi = maxTree;
    	int result = 0;
    	
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		long getSize = getTrees(mid);
    		
    		if(getSize >= M) {
    			result = mid;
    			lo = mid + 1;
    		} else {
    			hi = mid - 1;
    		}
    	}
    	return result;
    }
    
    static long getTrees(int H) {
    	long result = 0;
    	for (int i = 0; i < trees.length; i++) {
    		int curTree = trees[i];
			if(curTree > H) result += curTree - H;
		}
    	return result;
    }
}
