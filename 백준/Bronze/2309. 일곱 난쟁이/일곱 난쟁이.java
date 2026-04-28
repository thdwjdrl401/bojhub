import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];
        }
        Arrays.sort(arr);
        int[] notD = new int[2];
        for(int i = 0; i < 8; i++) {
        	for(int j = i + 1; j < 9; j++) {
        		if(sum - arr[i] - arr[j] == 100) {
        			notD[0] = i;
        			notD[1] = j;
        		}
        	}
        }
        for(int i = 0; i < 9; i++) {
        	if(i != notD[0] && i != notD[1])System.out.println(arr[i]);
        }
        
    }
}