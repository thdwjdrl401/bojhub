import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String number = br.readLine();
    	int sum = 0;
    	for (int i = 0; i < number.length(); i++) {
    		sum += Integer.parseInt(number.substring(i, i+1));
		}
    	System.out.println(sum);
    }
}
