import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long max = Math.max(A, B);
        long min = Math.min(A, B);
        if(A != B)System.out.println(max - min - 1);
        else System.out.println(0);
        
        for(long i = min + 1; i < max; i++)System.out.print(i + " ");
    }
}