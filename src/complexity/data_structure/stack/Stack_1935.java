package src.complexity.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Stack_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        char[] arr = postfix.toCharArray();
        HashMap<Character, Double> operands = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        char letters = 'A';

        for(int i = 0 ; i < N ; i++){
            operands.put(letters, Double.parseDouble(br.readLine()));
            letters++;
        }

        int count = 0;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != '*' && arr[i] != '+' && arr[i] != '-' && arr[i] != '/'){
                stack.push(operands.get(arr[i]));
                count++;
            } else {
               double answer = 0;
               double B = stack.pop();
               double A = stack.pop();

               switch(arr[i]) {
                   case '+' :
                       answer = A + B;
                       stack.push(answer);
                   break;
                   case '-' :
                       answer = A - B;
                       stack.push(answer);
                       break;
                   case '*' :
                       answer = A * B;
                       stack.push(answer);
                       break;
                   case '/' :
                       answer = A / B;
                       stack.push(answer);
                       break;
               }
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));


    }
}
