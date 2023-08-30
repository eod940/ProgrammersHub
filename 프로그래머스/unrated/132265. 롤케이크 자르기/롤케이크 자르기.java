import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> setL = new HashSet<>();        
        Map<Integer, Integer> mapR = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            mapR.put(topping[i], mapR.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            setL.add(topping[i]);
            mapR.put(topping[i], mapR.get(topping[i]) - 1);

            if (mapR.get(topping[i]) == 0) {
                mapR.remove(topping[i]);
            }

            if (setL.size() == mapR.size()) {
                answer += 1;
            }
        }

        return answer;
    }
}