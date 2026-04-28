import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= N; test_case++){
            String currentLine = br.readLine();
            int count = 0;
            String answer = "YES";
            for(int i = 0; i < currentLine.length(); i++){
                Character c = currentLine.charAt(i);
                if(c == '(') count++;
                else{
                    if(count <= 0){
                        answer = "NO";
                        break;
                    }
                    count--;
                }
            }
            if(count != 0) answer = "NO";
            System.out.println(answer);
        }
    }
}
