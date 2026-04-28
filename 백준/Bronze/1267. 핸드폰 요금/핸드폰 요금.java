import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int Y = 0;
        int M = 0;
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	Y += (arr[i] / 30 + 1) * 10;
        	M += (arr[i] / 60 + 1) * 15;
        } 
        if(Y > M) System.out.println("M " + M);
        else if(Y == M) System.out.println("Y M " + M);
        else System.out.println("Y " + Y);
    }
}