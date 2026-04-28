import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		String[] array = new String[set.size()];
		set.toArray(array);
		Arrays.sort(array, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
		for (int i = 0; i < set.size(); i++) {
			System.out.println(array[i]);
		}
	}
}
