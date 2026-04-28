import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String cur = br.readLine();
			set.add(cur);
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String cur = br.readLine();
			if(set.contains(cur)) list.add(cur);
		}
		list.sort(Comparator.naturalOrder());
		System.out.println(list.size());
		for(String s : list)System.out.println(s);
	}
}