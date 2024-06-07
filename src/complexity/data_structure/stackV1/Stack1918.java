package src.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1918 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < input.length; i++){
            if(input[i] != '+' && input[i] != '-' && input[i] != '*' && input[i] != '/' && input[i] != '(' && input[i] != ')'){
                sb.append(input[i]);
            }else if(stack.isEmpty()) {
                stack.push(input[i]);
            }else if(input[i] == '*' || input[i] == '/'){
                if(stack.peek() == '+' || stack.peek() == '-'|| stack.peek() == '('){
                    stack.push(input[i]);
                }else {
                    while(!stack.isEmpty()){
                        if(stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') break;
                        sb.append(stack.pop());
                    }
                    stack.push(input[i]);
                }
            }else if(input[i] == '+' || input[i] == '-'){
                if(stack.peek()== '(') {
                    stack.push(input[i]);
                }else{
                    while(!stack.isEmpty()){
                        if(stack.peek() == '(') break;
                        sb.append(stack.pop());
                    }
                    stack.push(input[i]);
                }
            }else if(input[i] == ')') {
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(input[i] == '(') {
                stack.push(input[i]);
            }

        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
