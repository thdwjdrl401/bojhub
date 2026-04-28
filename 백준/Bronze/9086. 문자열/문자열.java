import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append('\n');
		}
        System.out.println(sb);
	}
}
