package src.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack10828 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            switch(input[0]) {
                case "push" :
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop" :
                    if(stack.size() > 0) System.out.println(stack.pop());
                    else System.out.println(-1);
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top" :
                    if(stack.size() > 0) System.out.println(stack.peek());
                    else System.out.println(-1);
                    break;
            }
        }
    }
}
