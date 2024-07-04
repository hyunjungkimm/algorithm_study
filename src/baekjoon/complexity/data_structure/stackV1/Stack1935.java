package src.baekjoon.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack1935 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        Map<Character, Double> map = new HashMap<>();
        double answer = 0;
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i<N; i++){
            map.put((char)('A'+i), Double.parseDouble(br.readLine()));
        }

        for(int i = 0; i<input.length; i++){
            if(input[i] !='+' && input[i] !='-' && input[i] !='*' && input[i] !='/'){
                stack.push(map.get(input[i]));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                char op = input[i];
                switch(op){
                    case '+' :
                        answer = num2 + num1;
                        stack.push(answer);
                        break;
                    case '-' :
                        answer = num2 - num1;
                        stack.push(answer);
                        break;
                    case '*' :
                        answer = num2 * num1;
                        stack.push(answer);
                        break;
                    case '/' :
                        answer = num2 / num1;
                        stack.push(answer);
                        break;
                }
            }
        }

        System.out.println(String.format("%.2f",stack.pop()));

    }
}
