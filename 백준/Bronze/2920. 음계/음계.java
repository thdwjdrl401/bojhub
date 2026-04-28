import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	boolean isAscending = true;
    	boolean isDescending = true;
    	int ascending = 0;
    	int descending = 9;
    	for (int i = 0; i < 8; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(isAscending && ++ascending != cur) isAscending = false;
			if(isDescending && --descending != cur) isDescending = false;
			if(!isAscending && !isDescending) break;
		}
    	if(isAscending)System.out.println("ascending");
    	else if(isDescending)System.out.println("descending");
    	else System.out.println("mixed");
    }
}