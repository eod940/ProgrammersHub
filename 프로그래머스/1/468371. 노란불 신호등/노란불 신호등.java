class Solution {
    public int solution(int[][] signals) {
        int maxTime = 2000000; 

        // 시간 t를 1초부터 증가시키며 확인
        for (int t = 1; t <= maxTime; t++) {
            boolean allYellow = true;
            
            // 현재 시간 t에 모든 신호등이 노란불인지 검사
            for (int i = 0; i < signals.length; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int cycle = g + y + r;
                int sign = (t-1) % cycle;
                
                // 만약 현재 신호등이 노란불이 아니라면 다음 시간 탐색
                if (sign < g || sign >= g+y) {
                    allYellow = false;
                    break;
                }
            }
            
            // 노란불인 경우 바로 반환
            if (allYellow) {
                return t; 
            }
        }
        
        // 시간이 끝날 때까지 모두 노란불이 되는 경우가 없다면 -1 반환
        return -1; 
    }
}