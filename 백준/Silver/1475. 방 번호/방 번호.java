import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String n = br.readLine();
    	int[] number = new int[10];
    	for(int i = 0; i < n.length(); i++) {
    		int curN = Integer.parseInt(n.substring(i, i + 1));
    		number[curN]++;
    	}
    	number[6] = (number[6] + number[9] + 1) / 2;
    	number[9] = 0;
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < 10; i++) {
    		max = Math.max(max, number[i]);
    	}
    	System.out.println(max);
    }
}
