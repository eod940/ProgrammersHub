import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> a = Arrays.asList(0, 0, 0);
        List<Integer> result = new ArrayList<>();

        int max = 0;

        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            int n = i % s1.length;
            int m = i % s2.length;
            int k = i % s3.length;

            if (s1[n] == answers[i]) {
                a.set(0, a.get(0) + 1);
            }
            if (s2[m] == answers[i]) {
                a.set(1, a.get(1) + 1);
            }
            if (s3[k] == answers[i]) {
                a.set(2, a.get(2) + 1);
            }
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(a.get(i), max);
        }

        for (int i = 0; i < 3; i++) {
            if (a.get(i) == max) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}