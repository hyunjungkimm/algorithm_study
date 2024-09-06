/**
 * Author    : 김현정
 * Date      : 2024.09.06(금)
 * Runtime   :
 * Memory    :
 * Algorithm : [프로그래머스]LV2 - 42584 주식가격
 */
package src.programmers.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class 주식가격_42584 {
    public static void main(String[] args) {
        주식가격_42584 solution = new 주식가격_42584();
        int[] result = solution.solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();

        for(int price : prices) {
            queue.add(price);
        }

        int index = 0;

        while(!queue.isEmpty()) {
            int count = 0;
            for(int i = index +1; i < prices.length; i++) {
                count++;
                if(queue.peek() > prices[i]) {
                    break;
                }
            }
            queue.remove();
            answer[index++] = count;
        }

        return answer;
    }
}
