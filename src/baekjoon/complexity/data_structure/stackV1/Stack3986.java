package src.baekjoon.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack3986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < input.length; j++) {
                if(stack.isEmpty()) {
                    stack.push(input[j]);
                }else if(input[j] == stack.peek()) {
                    stack.pop();
                }else {
                    stack.push(input[j]);
                }
            }
            if(stack.isEmpty()) count++;
        }

        System.out.println(count);
    }
}
