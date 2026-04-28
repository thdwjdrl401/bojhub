import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	while (!s.equals("0")) {
        	boolean isBreak = false;
    		Deque<Character> dq = new ArrayDeque<>();
    		for (int i = 0; i < s.length() / 2; i++) {
				dq.push(s.charAt(i));
			}
    		for (int i = (s.length() + 1) / 2; i < s.length(); i++) {
    			if(s.charAt(i) != dq.pop()) {
    				System.out.println("no");
    				isBreak = true;
    				break;
    			}
			}
    		if(!isBreak)System.out.println("yes");
        	s = br.readLine();
    	}
    }
}