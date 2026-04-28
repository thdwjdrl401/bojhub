import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());
        
        long mul = A * B * C;
        int[] count = new int[10];
        String s = Long.toString(mul);
        for(int i = 0; i < s.length(); i++) count[Integer.parseInt(s.substring(i, i+1))]++;
        for(int i = 0; i < 10; i++) System.out.println(count[i]);
        
        
    }
}