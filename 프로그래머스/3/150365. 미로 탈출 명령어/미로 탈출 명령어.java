import java.util.*;  
class Solution {
    // d, l, r, u
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, -1, 1, 0};
    char[] dChar = {'d', 'l', 'r', 'u'};
    int N, M;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        Deque<Obj> dq = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];
        Obj start = new Obj();
        start.r = x;
        start.c = y;
        start.d = 0;
        dq.offer(start);
        while(!dq.isEmpty()){
            Obj cur = dq.poll();
            if(cur.d == k && cur.r == r && cur.c == c) return cur.s;
            if(cur.d == k) continue;
            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nd = cur.d + 1;
                if(!check(nr, nc)) continue;
                if(visited[nr][nc][nd]) continue;
                Obj next = new Obj();
                next.s = cur.s + dChar[d];
                next.r = nr;
                next.c = nc;
                next.d = nd;
                dq.offer(next);
                visited[nr][nc][nd] = true;
            }
        }
        return "impossible";
    }
    class Obj{
        String s = "";
        int r, c, d;
        
    }
    public boolean check(int nr, int nc){
        return nr <= N && nr > 0 && nc <= M && nc > 0;
    }
}