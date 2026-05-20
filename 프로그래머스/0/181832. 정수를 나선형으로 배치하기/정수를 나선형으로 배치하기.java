class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        // 오른쪽(0), 아래(1), 왼쪽(2), 위(3)... 반복(mod 4)
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = 0;
        int c = 0;
        int dir = 0; // 처음 이동 방향
        
        // 1부터 n제곱까지 숫자 채우기
        for (int i = 1; i <= n * n; i++) {
            answer[r][c] = i;
            
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || answer[nextR][nextC] != 0) {
                dir = (dir + 1) % 4; 

                nextR = r + dr[dir];
                nextC = c + dc[dir];
            }
            
            r = nextR;
            c = nextC;
        }
        
        return answer;
    }
}