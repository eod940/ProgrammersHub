import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n).chars()
                .map(data -> data - '0')
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining());
        
        long answer = Long.parseLong(s);
        return answer;
    }
}