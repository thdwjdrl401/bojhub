import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        if(!check(gcdA, arrayB)) gcdA = 0;
        int gcdB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        if(!check(gcdB, arrayA)) gcdB = 0;
        return Math.max(gcdA, gcdB);
    }
    
    private boolean check(int gcd, int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] % gcd == 0) return false;
        }
        return true;
    }
    
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}