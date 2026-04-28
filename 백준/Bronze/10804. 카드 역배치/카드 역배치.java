import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[10][2];
        int[] result = new int[20];
        for(int i = 1; i <= 20; i++)result[i - 1] = i;
        for(int i = 0; i < 10; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
        	for(int j = 0; j < (arr[i][1] - arr[i][0] + 1) / 2; j++) {
        		int tmp = result[arr[i][0] -1 + j];
        		result[arr[i][0] -1 + j] = result[arr[i][1] - 1 - j];
        		result[arr[i][1] - 1 - j] = tmp;
        	}
        }
        for(int i = 0; i < 20; i++)System.out.print(result[i] + " ");
    }
}

