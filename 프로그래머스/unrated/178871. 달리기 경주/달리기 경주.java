import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndex = new HashMap<>();

        // player 순위(index) 찾기
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }
        
        // 순위 옮기기
        for (int i = 0; i < callings.length; i++) {
            String backPlayer = callings[i];
            String frontPlayer = players[playerIndex.get(backPlayer)-1];
            int frontPlayerIndex = playerIndex.get(frontPlayer);
            int backPlayerIndex = playerIndex.get(backPlayer);

            // 뒷 선수에게 추월 당한다 (+1)
            playerIndex.replace(frontPlayer,
                    playerIndex.get(backPlayer));
            players[frontPlayerIndex] = backPlayer;

            // 앞 선수를 제친다 (-1)
            playerIndex.replace(backPlayer,
                    frontPlayerIndex);
            players[backPlayerIndex] = frontPlayer;
        }

        return players;
    }
}