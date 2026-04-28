import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String s = br.readLine();
    	int count = 0;
    	for (int i = 0; i < s.length() - 1; i++) {
			char c = s.charAt(i);
			char nextC = s.charAt(i+1);
			if(c == 'c') {
				if(nextC == '=' || nextC == '-') {
					count++;
					i++;
				}
			} else if(c == 'd') {
				if(nextC == 'z' && i < s.length() - 2 && s.charAt(i+2) == '=') {
					count+=2;
					i += 2;
				} else if(nextC == '-') {
					count++;
					i++;
				}
			} else if(c == 'l') {
				if(nextC == 'j') {
					count++;
					i++;
				}
			} else if(c == 'n') {
				if (nextC == 'j') {
					count++;
					i++;
				}
			} else if(c == 's') {
				if(nextC == '=') {
					count++;
					i++;
				}
			} else if(c == 'z') {
				if(nextC == '=') {
					count++;
					i++;
				}
			}
		}
    	System.out.println(s.length() - count);
    }
}
