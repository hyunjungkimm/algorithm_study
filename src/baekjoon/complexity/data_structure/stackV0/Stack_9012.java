package src.baekjoon.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N ; i++){
            Stack<String> stack = new Stack<>();
            int count = 0;

            String st = br.readLine();
            char[] chars = st.toCharArray();

            for(int j = 0; j<chars.length ; j++){
                if(chars[j] == '(') {
                    stack.push(String.valueOf(chars[j]));
                } else if(chars[j] == ')') {
                    if(stack.isEmpty()){
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty() || count > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
