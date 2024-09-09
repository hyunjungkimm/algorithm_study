package src.programmers.sort;

/**
 * Author    : 김현정
 * Date      : 2024.09.09(월)
 * Runtime   :
 * Memory    :
 * Algorithm : [programmers]Sort - LV1_42748 k번째수
 */

import java.util.*;

class k번째수_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
        }
        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] arr1 = {};

        for(int i = 0; i < commands.length; i++) {
            arr1 = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr1);
            answer[i] = arr1[commands[i][2]-1];
        }
        return answer;
    }
}
