import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 0; test_case < 3; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;
            for(int i = 0; i < 4; i++) {
            	if(Integer.parseInt(st.nextToken()) == 0) count++;
            }
            char result = 'A';
            
            if(count == 0) result = 'E';
            else result += count - 1;
            System.out.println(result);
        	
        }
    }
}

