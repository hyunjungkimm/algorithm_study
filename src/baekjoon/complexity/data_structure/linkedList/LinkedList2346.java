package src.baekjoon.complexity.data_structure.linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class LinkedList2346 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int num = 0;
        while(!deque.isEmpty()) {
            int result = deque.removeFirst();
            sb.append(result + " ");
            num = Integer.parseInt(input[result - 1]);

            if(deque.isEmpty()) break;

            if(num < 0) {
                num = -num;
                for(int j = 0; j < num; j++) {
                    deque.addFirst(deque.removeLast());
                }
            }else {
                for(int j = 0; j < num - 1; j++) {
                    deque.addLast(deque.removeFirst());
                }
            }

        }

        System.out.println(sb.toString());


    }
}
