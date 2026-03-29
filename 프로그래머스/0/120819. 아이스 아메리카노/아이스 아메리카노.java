class Solution {
    public int[] solution(int money) {
        int americano = money / 5500;
        int changes = money % 5500;
        int[] answer = {americano, changes};
        return answer;
    }
}