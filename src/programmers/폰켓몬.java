package src.programmers;

import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        //N/2마리
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(map.size() >= nums.length/2) return nums.length/2;
        else return map.size();
    }
}
