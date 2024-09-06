package src.programmers.stack_queue;

import java.util.*;

/**
 * Author    : 김현정
 * Date      : 2024.09.06(금)
 * Runtime   :
 * Memory    :
 * Algorithm : [프로그래머스 - 스택]LV1 - 12906 같은 숫자는 싫어
 */

class 같은숫자는싫어_12906 {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();

        for(int num : arr) {
            if(stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        answer = new int[stack.size()];
        int index = stack.size() -1;

        while(!stack.isEmpty()) {
            answer[index] = stack.pop();
            index--;
        }

        return answer;
    }

    // return s.stream().mapToInt(i -> (int)i).toArray();
}
