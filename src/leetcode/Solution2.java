package src.leetcode;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int minusNum = target - nums[i];
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] == minusNum) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }

            }
        }
        return result;
    }
}
