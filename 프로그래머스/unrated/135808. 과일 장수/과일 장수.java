import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;
        
        Arrays.sort(score);
        
        int start = score.length % m;
        
        if (start == 0) {
            for (int i = 0; i < score.length; i++) {
                count += 1;
                if (count % m == 0) {
                    answer += score[i-m+1] * m;
                }
            }
        } else {
            for (int i = start; i < score.length; i++) {
                count += 1;
                if (count % m == 0) {
                    answer += score[i-m+1] * m;
                }
            }
        }
        
        return answer;
    }
}