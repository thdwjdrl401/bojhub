import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[] seq = new int[5];
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);
        System.out.println(max);
    }
    
    static void perm(int depth) {
        if (depth == 5) {
            int curResult = simulation();
            max = Math.max(max, curResult);
            return;
        }
        for (int i = 0; i < 4; i++) {
            seq[depth] = i;
            perm(depth + 1);
        }
    }
    
    static int simulation() {
        int[][] tmpMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            tmpMap[i] = map[i].clone();
        }

        for (int i = 0; i < 5; i++) {
            move(tmpMap, seq[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, tmpMap[i][j]);
            }
        }
        return result;
    }

    static int[] merge(int[] line) {
        int[] temp = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            if (line[i] != 0) temp[len++] = line[i];
        }

        int[] result = new int[N];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            if (i + 1 < len && temp[i] == temp[i + 1]) {
                result[idx++] = temp[i] * 2;
                i++;
            } else {
                result[idx++] = temp[i];
            }
        }

        return result;
    }
    
    static void move(int[][] tmpMap, int dir) {
        if (dir == 0) { // 위
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) {
                    line[r] = tmpMap[r][c];
                }

                int[] merged = merge(line);

                for (int r = 0; r < N; r++) {
                    tmpMap[r][c] = merged[r];
                }
            }
        } 
        else if (dir == 1) { // 오른쪽
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) {
                    line[c] = tmpMap[r][N - 1 - c];
                }

                int[] merged = merge(line);

                for (int c = 0; c < N; c++) {
                    tmpMap[r][N - 1 - c] = merged[c];
                }
            }
        } 
        else if (dir == 2) { // 아래
            for (int c = 0; c < N; c++) {
                int[] line = new int[N];
                for (int r = 0; r < N; r++) {
                    line[r] = tmpMap[N - 1 - r][c];
                }

                int[] merged = merge(line);

                for (int r = 0; r < N; r++) {
                    tmpMap[N - 1 - r][c] = merged[r];
                }
            }
        } 
        else { // 왼쪽
            for (int r = 0; r < N; r++) {
                int[] line = new int[N];
                for (int c = 0; c < N; c++) {
                    line[c] = tmpMap[r][c];
                }

                int[] merged = merge(line);

                for (int c = 0; c < N; c++) {
                    tmpMap[r][c] = merged[c];
                }
            }
        }
    }
}