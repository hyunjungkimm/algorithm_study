package src.baekjoon.complexity.data_structure.stackV1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1725 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long max = 0;
        long[] arr = new long[N];

        for(int i = 0 ; i < N ; i++){
            long input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }

        for(int i = 0 ; i < N ; i++){
            if(stack.isEmpty() || arr[stack.peek()] < arr[i]){
                stack.push(i);
            } else {
                while(arr[stack.peek()] >= arr[i]){
                    int index = stack.pop();
                    if(stack.size() == 0) {
                        long temp = arr[index] * (i);
                        max = Math.max(max, temp);
                        break;
                    }else {
                        max = Math.max(max, arr[index] * (i-stack.peek()-1));
                    }
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            if(stack.size() == 0) {
                max = Math.max(max, arr[index] * N);
                break;
            }else {
                max = Math.max(max, arr[index] * (N-stack.peek()-1));
            }
        }
        System.out.println(max);
    }
}
