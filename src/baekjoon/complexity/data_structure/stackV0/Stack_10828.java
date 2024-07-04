package src.baekjoon.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String command = reader.readLine();
            String[] commandArr = command.split(" ");
            switch(commandArr[0]) {
                case "push":
                    stack.push(Integer.parseInt(commandArr[1]));
                    break;
                case "pop":
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "top" :
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
                case "empty" :
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
            }
        }
    }
}
