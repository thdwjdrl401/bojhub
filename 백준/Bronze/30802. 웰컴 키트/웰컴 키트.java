import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	long N = Long.parseLong(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long[] array = new long[6];
    	for (int i = 0; i < 6; i++) array[i] = Long.parseLong(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	long T = Long.parseLong(st.nextToken());
    	long P = Long.parseLong(st.nextToken());
    	int setT = 0;
    	for (int i = 0; i < 6; i++) {
    		long cur = array[i];
    		setT += (cur - 1) / T;
    		if(cur != 0) setT++;
    	}
    	long setP = N == 0 ? 0 : N / P;
    	long sepP = N % P;
    	System.out.println(setT);
    	System.out.println(setP + " " + sepP);
    }
}