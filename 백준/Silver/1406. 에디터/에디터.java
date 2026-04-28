import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            left.addLast(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            char cmd = line.charAt(0);

            if (cmd == 'L') {
                if (!left.isEmpty()) right.addLast(left.removeLast());
            } else if (cmd == 'D') {
                if (!right.isEmpty()) left.addLast(right.removeLast());
            } else if (cmd == 'B') {
                if (!left.isEmpty()) left.removeLast();
            } else if (cmd == 'P') {
                char x = line.charAt(2);
                left.addLast(x);
            }
        }

        StringBuilder sb = new StringBuilder(left.size() + right.size());

        for (char c : left) sb.append(c);

        while (!right.isEmpty()) sb.append(right.removeLast());

        System.out.println(sb);
    }
}
