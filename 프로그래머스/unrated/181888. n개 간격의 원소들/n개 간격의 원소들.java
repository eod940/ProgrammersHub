import java.util.*;

class Solution {
    public int[] solution(int[] nums, int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i % n == 0) {
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}