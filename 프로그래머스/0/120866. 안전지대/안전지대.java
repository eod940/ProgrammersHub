class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        // 위험 지역을 표시할 새로운 배열 (true: 위험, false: 안전)
        boolean[][] isDanger = new boolean[n][n];

        // 1. 지뢰(1) 위치 찾기
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1) {
                    // 2. 지뢰를 발견하면 주변 9칸(자신 포함)을 위험 지역으로 마킹
                    markDanger(r, c, n, isDanger);
                }
            }
        }

        // 3. 안전한 지역(false) 개수 세기
        int safeCount = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!isDanger[r][c]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    // 지뢰 주변 8방향 + 자기자신을 마킹하는 보조 메서드
    private void markDanger(int r, int c, int n, boolean[][] isDanger) {
        // 상, 하, 좌, 우 및 대각선 4방향을 위한 좌표 변화량
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nr = r + i;
                int nc = c + j;

                // 배열의 범위를 벗어나지 않는지 확인 (매우 중요!)
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    isDanger[nr][nc] = true;
                }
            }
        }
    }
}