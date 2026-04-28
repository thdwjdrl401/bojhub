import java.io.*;
import java.util.*;

public class Main {

    static int[] dice = new int[10];
    static int[] horse = new int[4];
    static int[] score = new int[33];
    static int[] next = new int[33];
    static int[] blue = new int[33];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init();
        dfs(0, 0);

        System.out.println(answer);
    }

    static void init() {
        for (int i = 0; i <= 20; i++) {
            score[i] = i * 2;
        }

        for (int i = 0; i < 20; i++) {
            next[i] = i + 1;
        }
        next[20] = 32; // 40 -> 도착

        score[21] = 13;
        score[22] = 16;
        score[23] = 19;

        score[24] = 22;
        score[25] = 24;

        score[26] = 28;
        score[27] = 27;
        score[28] = 26;

        score[29] = 25;
        score[30] = 30;
        score[31] = 35;

        score[32] = 0; // 도착

        blue[5] = 21;
        blue[10] = 24;
        blue[15] = 26;

        next[21] = 22;
        next[22] = 23;
        next[23] = 29;

        next[24] = 25;
        next[25] = 29;

        next[26] = 27;
        next[27] = 28;
        next[28] = 29;

        next[29] = 30;
        next[30] = 31;
        next[31] = 20;
    }

    static void dfs(int turn, int sum) {
        if (turn == 10) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (horse[i] == 32) continue;

            int prev = horse[i];
            int move = move(prev, dice[turn]);

            if (move != 32 && isOccupied(i, move)) continue;

            horse[i] = move;
            dfs(turn + 1, sum + score[move]);
            horse[i] = prev;
        }
    }

    static int move(int start, int dist) {
        int cur = start;

        if (cur == 32) return 32;

        if (blue[cur] != 0) {
            cur = blue[cur];
            dist--;
        } else {
            cur = next[cur];
            dist--;
        }

        while (dist > 0 && cur != 32) {
            cur = next[cur];
            dist--;
        }

        return cur;
    }

    static boolean isOccupied(int idx, int pos) {
        for (int i = 0; i < 4; i++) {
            if (i == idx) continue;
            if (horse[i] == pos) return true;
        }
        return false;
    }
}