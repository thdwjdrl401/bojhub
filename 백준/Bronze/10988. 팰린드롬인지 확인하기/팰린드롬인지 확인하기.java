import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isP = true;
        for(int i = 0; i < s.length()  / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                isP = false;
                break;
            }
        }
        System.out.println(isP ? 1 : 0);
        
    }
}