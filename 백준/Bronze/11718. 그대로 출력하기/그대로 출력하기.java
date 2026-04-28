import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
        	sb.append(s).append('\n');
        }
        System.out.println(sb);
	}
}

