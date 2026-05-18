import java.util.*;

class Solution {
    
    String[] words = {"aya", "ye", "woo", "ma"};
    boolean[] visited = new boolean[4];
    List<String> wordsPermutation = new ArrayList<>();
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        // 단어 조합 전부 만들기
        createPermutation("");
        
        // 발음할 수 있는 단어 찾기
        for (String str : babbling) {
            for (String word : wordsPermutation) {
                if (str.equals(word)) {
                    answer++;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    public void createPermutation(String str) {
        // 단어 넘어오면 저장
        if (!str.isEmpty()) {
            wordsPermutation.add(str);
        }
        
        // 단어 조합
        for(int i = 0; i < words.length; i++) {
            // 이미 쓴건 넘어가기
            if (visited[i]) continue;
            
            visited[i] = true;
            createPermutation(str + words[i]);
            visited[i] = false;            
        }
    }
}