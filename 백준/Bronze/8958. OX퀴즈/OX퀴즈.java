import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int sum = 0;
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c == 'O') count++;
				else count = 0;
				sum += count;
			}
			System.out.println(sum);
		}
    }
}