import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String result = "Possible";
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			if(A.length() != B.length()) result = "Impossible";
			else {
				char[] arrayA = new char[A.length()];
				char[] arrayB = new char[B.length()];
				for(int j = 0; j < A.length(); j++) {
					arrayA[j] = A.charAt(j);
					arrayB[j] = B.charAt(j);
				}
				Arrays.sort(arrayA);
				Arrays.sort(arrayB);
				for(int j = 0; j < A.length(); j++) {
					if(arrayA[j] != arrayB[j]) {
						result = "Impossible";
						break;
					}
				}	
			}
			System.out.println(result);
		}
		
		
	}
}
