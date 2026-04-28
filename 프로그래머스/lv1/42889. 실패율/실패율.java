import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        double[] fail = new double[N];
        int stage = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = stage; j < stages.length; j++) {
                if (stages[j] == i) count++;
                else if (stages[j] > i) break;
            }
            int reached = stages.length - stage;
            fail[i - 1] = (reached == 0) ? 0 : (double) count / reached;
            stage += count;
        }

        Integer[] answer = new Integer[N];
        for (int i = 0; i < N; i++) answer[i] = i + 1;

        Arrays.sort(answer, (a, b) -> {
            int result = Double.compare(fail[b - 1], fail[a - 1]);
            return (result != 0) ? result : Integer.compare(a, b);
        });

        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}
