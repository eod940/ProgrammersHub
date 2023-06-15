import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
//         int answer = 0;
//         StringBuilder sb = new StringBuilder();
        
//         for (int i : array) { sb.append(i); }
        
//         answer = (int) Arrays.stream(sb.toString().split(""))
//                 .filter(data -> data.equals("7"))
//                 .count();
//         return answer;
        
        int answer = 0;
        for (int i : array) {
            if (Integer.toString(i).contains("7")){
                answer += Integer.toString(i).length() -
                        Integer.toString(i)
                                .replace("7", "")
                                .length();
            }
        }
        return answer;
    }
}