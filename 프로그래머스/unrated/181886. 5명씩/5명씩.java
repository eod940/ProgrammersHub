import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> s = new ArrayList<>();
        
        for (int i = 0; i < names.length; i++) {
            if (i % 5 == 0) {
                s.add(names[i]);
            }
        }
        String[] answer = new String[s.size()];
        for (int i = 0; i < s.size(); i++) {
            answer[i] = s.get(i);
        }
        return answer;
    }
}