import java.util.*;
import java.io.*;
 
class Main
{
    static int K;
    static int sum = 0;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int preD = 0;
        int firstD = 0;
        int longX = 0;
        int longY = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 6; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int dir = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	if(i == 0) firstD = d;
        	int mul = preD * d;
			sum += mul;
			preD = d;
			if(arr[dir] != 0) {
				if(dir == 4 || dir == 3) {
					longX = dir == 3 ? 4 : 3; 
				}else {
					longY = dir == 1 ? 2 : 1;
				}
			}
			arr[dir] = d;
		}
        sum += preD * firstD;
        int result = sum - 2 * (arr[longX] * arr[longY]);
        System.out.println(result * K);
    }
}


