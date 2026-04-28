import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder line = new StringBuilder();

        for (int i = 0; i < N; i++) {
            line.append('*');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(line).append('\n');

        System.out.print(sb);
	}
}