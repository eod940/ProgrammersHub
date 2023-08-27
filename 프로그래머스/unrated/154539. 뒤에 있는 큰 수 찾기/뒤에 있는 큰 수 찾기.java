import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int l = numbers.length;
        Stack<Integer> s = new Stack<>();
    
        s.add(0);
        
        for (int i = 1; i < l; i++) {
            int cur = numbers[i];
            
            while (!s.isEmpty() && numbers[i] > numbers[s.peek()]) {
                answer[s.pop()] = numbers[i];
            }
            
            s.add(i);
        }
        
        while (!s.isEmpty()) {
            answer[s.pop()] = -1;
        }
        return answer;
    }
}