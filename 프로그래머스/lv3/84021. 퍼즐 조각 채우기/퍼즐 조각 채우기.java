import java.util.*;
class Solution {
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<List<int[]>> holes = extractShapes(game_board, 0);
        List<List<int[]>> blocks = extractShapes(table, 1);
        boolean[] used = new boolean[blocks.size()];

        for(List<int[]> hole : holes){
            List<int[]> normHole = normalize(hole);
            boolean filled = false;
            for (int b = 0; b < blocks.size(); b++) {
                if (used[b]) continue;
                List<int[]> block = blocks.get(b);
                if(hole.size() != block.size()) continue;
                List<int[]> normBlock = normalize(block);
                for(int i = 0; i < 4; i++){
                    if(sameShape(normHole, normBlock)){
                        answer += hole.size();
                        used[b] = true;
                        filled = true;
                        break;
                    }
                    normBlock = rotate90(normBlock);
                }
                if (filled) break;
            }
        }
        
        return answer;
    }
    
    private List<int[]> rotate90(List<int[]> shape){
        List<int[]> rotated = new ArrayList<>(shape.size());
        for(int[] p : shape){
            int r = p[0], c = p[1];
            rotated.add(new int[]{c, -r});
        }
        return normalize(rotated);
    }
    
    private boolean sameShape(List<int[]> a, List<int[]> b){
        if(a.size() != b.size()) return false;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0]) return false;
            if(a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
    
    private List<List<int[]>> extractShapes(int[][] grid, int targetValue){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1 ,1};
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if(visited[row][col]) continue;
                if(grid[row][col] != targetValue) continue;
                
                List<int[]> cells = new ArrayList<>();
                Deque<int[]> dq = new ArrayDeque<>();
                dq.offer(new int[]{row, col});
                visited[row][col] = true;
                
                while(!dq.isEmpty()){
                    int[] cur = dq.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    
                    cells.add(new int[]{cr, cc});
                    
                    for(int i = 0; i < 4; i++){
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                        if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                        if(visited[nr][nc]) continue;
                        if(grid[nr][nc] != targetValue) continue;
                        visited[nr][nc] = true;
                        dq.offer(new int[]{nr, nc});
                    }
                }
                shapes.add(cells);
            }
        }
        return shapes;
    }
    
    private List<int[]> normalize(List<int[]> cells){
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] p : cells){
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        List<int[]> norm = new ArrayList<>();
        for(int[] p : cells){
            norm.add(new int[]{p[0] - minR, p[1] - minC});
        }
        
        norm.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        return norm;
    }
}