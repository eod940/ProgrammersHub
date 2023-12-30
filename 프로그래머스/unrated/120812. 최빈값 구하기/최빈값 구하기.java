import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());  // array 복사 리스트
        List<Integer> distinctList = Arrays.stream(array)
                .distinct()
                .boxed()
                .collect(Collectors.toList());  // array의 중복값을 하나로 만든 리스트
        List<Integer> frequency = new ArrayList<>();  // 빈도수를 담을 리스트

        // 빈도수 구하기
        for (int i : distinctList) {
            frequency.add(Collections.frequency(list, i));
        }

        // 최빈값
        int max = frequency.stream().mapToInt(data -> data)
                .max().orElse(0);

        list.clear();  // 역할 변경: 최빈값 넣을 리스트
        for (int i = 0; i < distinctList.size(); i++) {
            if (frequency.get(i) == max) {
                list.add(distinctList.get(i));
            }
        }
        
        if (list.size() > 1) { return -1; }
        else { return list.get(0); }
    }
}