import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> hm = new HashMap<>();
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < yearning.length; i++) {
            hm.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            int point = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (hm.get(photo[i][j]) == null) {
                    point += 0;
                } else {
                    point += hm.get(photo[i][j]);
                }
            }
            answer[i] = point;
        }
        return answer;
    }
}