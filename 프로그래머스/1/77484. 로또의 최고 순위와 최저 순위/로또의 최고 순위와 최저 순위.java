class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int zero = 0;
        int matches = 0;
        
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    matches++;
                }
            }
        }
        
        answer[0] = getScore(matches + zero);
        answer[1] = getScore(matches);
        return answer;
    }
    
    public int getScore(int matches) {
        if (matches < 2) 
            return 6;
        if (matches == 2)
            return 5;
        if (matches == 3)
            return 4;
        if (matches == 4)
            return 3;
        if (matches == 5)
            return 2;
        if (matches == 6)
            return 1;
        
        return -1;
    }
}