import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        int[] count = new int[1000];    // 0~1000 까지
        int answer = -1;                // 최빈값(답)
        int maxFrequency = 0;            // 최대 빈도수
        boolean isDup = false;
        
        // 빈도수 카운트
        for (int e : array) {
            count[e]++;
        }
        
        // 최빈값 찾기
        for (int i = 0; i < 1000; i++) {
            if (count[i] > maxFrequency) {
                maxFrequency = count[i];
                answer = i;
                isDup = false;
            }
            else if (count[i] == maxFrequency) {
                isDup = true;
            }
        }
        
        if (isDup) 
            return -1;
        else
            return answer;
        
    }
}