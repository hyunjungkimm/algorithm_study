package src.baekjoon.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_3986 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            Stack<Character> stream = new Stack<>();
            for(int j = 0; j < input.length; j++){
                if(stream.isEmpty() || stream.peek() != input[j]){
                    stream.push(input[j]);
                }else if(stream.peek() == input[j]){
                    stream.pop();
                }
            }
            if(stream.isEmpty()) count++;
        }
        System.out.println(count);
    }
}
