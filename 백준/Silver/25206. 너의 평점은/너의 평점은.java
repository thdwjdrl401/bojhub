import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double grade = 0;
        int gradeCnt = 0;
        
        for (int i = 0; i < 20; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	st.nextToken();
        	int curGradeCnt = Integer.parseInt(st.nextToken().substring(0, 1)); 
        	String curGrade = st.nextToken();
        	if(curGrade.equals("P")) continue;
        	gradeCnt += curGradeCnt;
        	grade += getGrade(curGrade, curGradeCnt);
		}
        System.out.printf("%.6f", grade / gradeCnt);
        
        
    }
    static double getGrade(String g, int gradeCount) {
    	if(g.equals("A+")) return 4.5 * gradeCount;
    	else if(g.equals("A0")) return 4.0 * gradeCount;
    	else if(g.equals("B+")) return 3.5 * gradeCount;
    	else if(g.equals("B0")) return 3.0 * gradeCount;
    	else if(g.equals("C+")) return 2.5 * gradeCount;
    	else if(g.equals("C0")) return 2.0 * gradeCount;
    	else if(g.equals("D+")) return 1.5 * gradeCount;
    	else if(g.equals("D0")) return 1.0 * gradeCount;
    	return 0;
    }
}
