package src.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack9012 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            char[] arr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            String answer = "YES";

            for(int j = 0; j < arr.length; j++){
                if(arr[j] == '(') stack.push(arr[j]);
                else if(arr[j] == ')') {
                    if(stack.isEmpty()){
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()){
                answer = "NO";
            }

            System.out.println(answer);
        }

    }
}
