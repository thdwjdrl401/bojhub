import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String A = br.readLine();
    	String B = br.readLine();
    	String C = br.readLine();
    	int a = Integer.parseInt(A);
    	int b = Integer.parseInt(B);
    	int c = Integer.parseInt(C);
    	System.out.println(a + b - c);
    	int AB = Integer.parseInt(A + B);
    	System.out.println(AB - c);
    }
}
