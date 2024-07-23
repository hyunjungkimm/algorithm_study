package src.leetcode;

public class Solution53 {
    int max = Integer.MIN_VALUE;
    int sum = 0;

    public int maxSubArray2(int[] nums) {
        int answer = nums[0], minAcc = 0, acc = nums[0];

        for(int i = 1; i < nums.length; i++) {
            minAcc = Math.min(minAcc, acc);
            acc += nums[i];
            answer = Math.max(answer, acc - minAcc);
        }
        return answer;
    }
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums) {
            sum = Math.max(num, sum+num);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        //int[] nums = {5,4,-1,7,8};
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {1};
        //int[] nums = {-2,1};
        //int[] nums = {-1,-2};
        System.out.println(solution53.maxSubArray(nums));
    }
}
