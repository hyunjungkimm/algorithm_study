package src.leetcode;

public class Solution7 {
    public int reverse(int x) {
        boolean isNegative = (x < 0) ? true : false;
        StringBuffer sb = new StringBuffer(x+"");
        String reverse = sb.reverse().toString().replace("-", "");

        long result = isNegative ? -Long.parseLong(reverse) : Long.parseLong(reverse);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE - 1) {
            return 0;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int result = solution7.reverse(-2147483648);
        System.out.println(result);
    }

}
