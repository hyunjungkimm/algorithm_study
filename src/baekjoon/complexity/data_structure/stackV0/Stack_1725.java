package src.baekjoon.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        Stack<Integer> stack = new Stack<>();
        long max = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
               long height = arr[stack.pop()];
               long width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
               max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            long height = arr[stack.pop()];
            int width = (stack.isEmpty()) ? N : N - stack.peek() - 1;
            long square = height * width;
            max = Math.max(max, square);
        }
        System.out.println(max);
    }
}
