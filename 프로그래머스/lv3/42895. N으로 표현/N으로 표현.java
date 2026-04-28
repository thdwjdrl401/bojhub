import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>(9);
        for (int i = 0; i <= 8; i++) dp.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            // 1) 붙여쓰기 값 추가 (예: 5, 55, 555 ...)
            int concat = 0;
            for (int k = 0; k < i; k++) concat = concat * 10 + N;
            dp.get(i).add(concat);
            System.out.println(dp.get(i));

            // 2) 분할 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> A = dp.get(j);
                Set<Integer> B = dp.get(i - j);
                System.out.print("A : " + A);
                System.out.print("B : " + B);
                
                for (int a : A) {
                    for (int b : B) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b); // 정수 나눗셈
                        if (a != 0) dp.get(i).add(b / a);
                    }
                }
            }

            if (dp.get(i).contains(number)) return i;
        }
        return -1;
    }
}
