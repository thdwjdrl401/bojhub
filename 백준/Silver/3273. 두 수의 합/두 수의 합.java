import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] num = new int[n];
    	for(int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
    	Arrays.sort(num);
    	int x = Integer.parseInt(br.readLine());
    	int count = 0;
    	int left = 0;
    	int right = n - 1;
    	while(left < right) {
    		int sum = num[left] + num[right];
    		if(sum == x) {
    			count++;
    			left++;
    			right--;
    		}
    		else if(sum < x) left++;
    		else right--;
    	}
    	System.out.println(count);
    	
    }
}
