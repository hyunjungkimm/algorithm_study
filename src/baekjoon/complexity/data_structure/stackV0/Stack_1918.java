package src.baekjoon.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] inputArray = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuffer answer = new StringBuffer();

        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == '*' || inputArray[i] == '/') {
                while(true) {
                    if(stack.empty()) {
                        stack.push(inputArray[i]);
                        break;
                    }else if(stack.peek() == '+' || stack.peek() == '-') {
                        stack.push(inputArray[i]);
                        break;
                    }else if (stack.peek() == '(') {
                        stack.push(inputArray[i]);
                        break;
                    }else if (stack.peek() == '*' || stack.peek() == '/') {
                        answer.append(stack.pop());
                    }
                }
            }else if(inputArray[i] == '+' || inputArray[i] == '-') {
                while(true) {
                    if(stack.empty()) {
                        stack.push(inputArray[i]);
                        break;
                    }else if (stack.peek() == '(') {
                        stack.push(inputArray[i]);
                        break;
                    }else if (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-') {
                        answer.append(stack.pop());
                    }
                }
            }else if(inputArray[i] == '(') {
                stack.push(inputArray[i]);
            }else if(inputArray[i] == ')') {
                while(stack.peek()!='(') {
                    answer.append(stack.pop());
                }
                stack.pop();
            }else {
                answer.append(inputArray[i]);
            }
        }
        while(!stack.empty()) {
            answer.append(stack.pop());
        }
        System.out.println(answer);
    }
}
