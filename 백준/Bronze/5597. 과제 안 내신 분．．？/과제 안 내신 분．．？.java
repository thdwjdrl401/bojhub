import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];
        int x  = 0;
        int y  = 0;
        for (int i = 0; i < 28; i++) {
        	int n = Integer.parseInt(br.readLine());
			arr[n] = true; 
		}
        
        for (int i = 1; i < 30; i++) {
			if(!arr[i]) {
				x = i;
				break;
			}
		}
        for (int i = 30; i > 0; i--) {
			if(!arr[i]) {
				y = i;
				break;
			}
		}
        
        System.out.println(x);
        System.out.println(y);
	}
}