import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
            
        	for(int j = 0; j < s.length(); j++) {
            	char c = s.charAt(j);
                if(c == '<') {
                	if(!left.isEmpty()) right.push(left.pop());
                } else if(c == '>') {
                	if(!right.isEmpty()) left.push(right.pop());
                } else if(c == '-') {
                	if(!left.isEmpty()) left.pop();
                } else {
                	left.push(c);
                }
        	}
            while(!right.isEmpty()) left.push(right.pop());
            StringBuilder sb = new StringBuilder();
            
            while(!left.isEmpty()) sb.append(left.pollLast());
            System.out.println(sb.toString());
        }
    }
}
