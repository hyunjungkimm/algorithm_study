package src.baekjoon.complexity.data_structure.linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LinkedList5397 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> leftStack = new Stack<>();
            Stack<Character> rightStack = new Stack<>();
            StringBuffer sb = new StringBuffer();

            for(int j = 0; j < arr.length; j++) {
                switch(arr[j]){
                    case '<' :
                        if(leftStack.isEmpty()) break;
                        rightStack.push(leftStack.pop());
                        break;
                    case '>' :
                        if(rightStack.isEmpty()) break;
                        leftStack.push(rightStack.pop());
                        break;
                    case '-' :
                        if(leftStack.isEmpty()) break;
                        leftStack.pop();
                        break;
                    default :
                        leftStack.push(arr[j]);
                }
            }

            while(!leftStack.isEmpty()){
                rightStack.push(leftStack.pop());
            }

            while(!rightStack.isEmpty()){
                sb.append(rightStack.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
