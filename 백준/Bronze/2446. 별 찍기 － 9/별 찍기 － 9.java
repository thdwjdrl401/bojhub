import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++) {
    			if(j < i)System.out.print(" ");
    			else System.out.print("*");
    		}
    		for(int j = N; j >= 1; j--) {
    			if(j < i + 1)continue;
    			else System.out.print("*");
    		}
    		System.out.println();
    	}
    	for(int i = N - 1; i >= 1; i--) {
    		for(int j = 1; j <= N; j++) {
    			if(j < i)System.out.print(" ");
    			else System.out.print("*");
    		}
    		for(int j = N; j >= 1; j--) {
    			if(j < i + 1) continue;
    			else System.out.print("*");
    		}
    		System.out.println();
    	}
    }
}
