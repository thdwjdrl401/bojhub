import java.util.*;

class Solution {
    String[] B;
    
    public int solution(String[] board) {
        B = board;
        boolean oIsFin = false;
        boolean xIsFin = false;
        int oCount = 0;
        int xCount = 0;
        for(int i = 0; i < 3; i++){
            String curS = board[i];
            for(int j = 0; j < 3; j++){
                char c = curS.charAt(j);
                if(c == 'O'){
                    if(c == 'O') oCount++;
                    if(check(i, j, c)){
                        if(xIsFin){
                            return 0;
                        }
                        oIsFin = true;
                    }
                }
                if(c == 'X'){
                    if(c == 'X') xCount++;
                    if(check(i, j, c)){
                        if(oIsFin){
                            return 0;
                        }
                        xIsFin = true;
                    }
                }
            }
        }
        if(xCount > oCount) return 0;
        if(xCount > oCount) return 0;
        if(oCount > xCount + 1) return 0;
        if(oIsFin && oCount != xCount + 1) return 0;
        if(xIsFin && oCount != xCount) return 0;
        return 1;
    }
    public boolean check(int i, int j, char charC){
        boolean col = true;
        boolean row = true;
        for(int c = 0; c < 3; c++){
            if(B[i].charAt(c) != charC){
                col = false;
            }
        }
        if(col) return true;
        for(int r = 0; r < 3; r++){
            if(B[r].charAt((j) % 3) != charC){
                row = false;
            }
        }
        if(row) return true;
        
        if(i == j){
            boolean col2 = true;
            for(int c = 0; c < 3; c++){
                if(B[c].charAt(c) != charC){
                    col2 = false;
                }
            }
            if(col2) return true;
        }
        if(i + j == 2){
            boolean row2 = true;
            for(int r = 0; r < 3; r++){
                if(B[(i + r) % 3].charAt(Math.abs(j - r) % 3) != charC){
                    row2 = false;
                }
            }
            if(row2) return true;
        }
        return false;
    }
}

// 00 01 02
// 10 11 12
// 20 21 22