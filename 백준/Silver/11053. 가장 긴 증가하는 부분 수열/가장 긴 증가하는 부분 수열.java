import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int size = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int x = Integer.parseInt(st.nextToken());
        	int idx = Arrays.binarySearch(arr,  0, size, x);
        	if(idx < 0) idx = -idx -1;
        	
        	arr[idx] = x;
        	if(idx == size) size++;
		}
        System.out.println(size);
    }
}
