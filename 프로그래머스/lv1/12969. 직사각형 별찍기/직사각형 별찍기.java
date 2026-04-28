import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int y = 0; y < b; y++){
            for(int x = 0; x < a; x++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}