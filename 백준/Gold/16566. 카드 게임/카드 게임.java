import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[] arrM, arrK;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arrM = new int[M];
        visited = new boolean[M];
        for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			arrM[i] = a;
		}
        st = new StringTokenizer(br.readLine());
        arrK = new int[K];
        for (int i = 0; i < K; i++) {
			int a = Integer.parseInt(st.nextToken());
			arrK[i] = a;
		}

        // 1. arrM 정렬
        Arrays.sort(arrM);
        
        // 2. 이분탐색으로 arrM에서 arrK보다 큰수 중 가장 작은 수 내기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
			int cur = arrK[i];
			int index = lowerBound(cur);
			while(true) {
				if(!visited[index]) break;
				if(index + 1 == M) break;
				index++;
			}
			visited[index] = true;
			sb.append(arrM[index]).append('\n');
		}
        System.out.println(sb);
    }
    
    static int lowerBound(int target) {
    	int left = 0;
    	int right = M;
    	while(left < right) {
    		int middle = (left + right) / 2;
    		
    		if(target >= arrM[middle]) {
    			left = middle + 1;
    		} else {
    			right = middle;
    		}
    	}
    	
    	return left;
    }
}