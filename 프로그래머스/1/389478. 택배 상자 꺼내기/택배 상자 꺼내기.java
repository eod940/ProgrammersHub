class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int boxNum = 1; 
        int boxIdx = 0; 
        int boxRow = 0; 
        
        // (n + w - 1) / w 는 나머지가 있을 때 올림 처리하는 수식
        int totalRow = (n + w - 1) / w; 
        int[][] boxes = new int[totalRow][w];
        
        // 박스 쌓기
        for (int r = 0; r < totalRow; r++) {
            for (int i = 0; i < w; i++) {
                if (boxNum > n) break; // n번 상자까지 모두 놓았다면 중단
                
                // 짝수 줄은 정방향, 홀수 줄은 역방향 인덱스 계산
                int currentCol = (r % 2 == 0) ? i : w - i - 1;
                boxes[r][currentCol] = boxNum;
                
                // 찾을 박스 줄과 인덱스 저장
                if (boxNum == num) {
                    boxIdx = currentCol;
                    boxRow = r;
                }
                
                boxNum++; // 방향에 상관없이 박스 번호는 항상 증가
            }
        }
        
        // 내릴 박스 수 찾기 (위층으로 올라가면서 체크)
        for (int row = boxRow; row < totalRow; row++) {
            if (boxes[row][boxIdx] != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}