import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		int maxStartCount = N * 2 - 1;
    		int starCount = 1 + 2 * (i - 1);
    		for(int j = 0; j < (maxStartCount - starCount) / 2; j++) System.out.print(" ");
    		for(int j = 0; j < starCount; j++)System.out.print("*");
    		System.out.println();
    	}
    }
}
