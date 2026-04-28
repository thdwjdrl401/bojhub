import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] arr;
	static List<Integer> list = new ArrayList<>(); 
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
		}
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
			int cur = arr[i];
			if(cur < list.get(list.size() - 1)) {
				list.add(cur);
			} else {
				for(int j = list.size() - 1; j >= 0; j--) {
					if(list.get(j) > cur) {
						list.set(j + 1, cur);
						break;
					}
					else if(j == 0) {
						list.set(0, cur);
						break;
					}
				}
			}
		}
        System.out.println(list.size());
    }
}
