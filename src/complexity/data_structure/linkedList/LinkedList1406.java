package src.complexity.data_structure.linkedList;

import java.io.*;
import java.util.*;

public class LinkedList1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stackLeft = new Stack<>();
        Stack<String> stackRight = new Stack<>();
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++){
            stackLeft.add(""+input[i]);
        }
        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            String[] strings = br.readLine().split(" ");
            switch(strings[0]){
                case "P" :
                    stackLeft.push(strings[1]);
                    break;
                case "L" :
                    if(stackLeft.empty()) break;
                    stackRight.push(stackLeft.pop());
                    break;
                case "D" :
                    if(stackRight.empty()) break;
                    stackLeft.push(stackRight.pop());
                    break;
                case "B" :
                    if(stackLeft.empty()) break;
                    stackLeft.pop();
                    break;
            }
        }
        while(!stackLeft.empty()){
            stackRight.push(stackLeft.pop());
        }
        StringBuffer sb = new StringBuffer();
        while(!stackRight.empty()){
            sb.append(stackRight.pop());
        }
        System.out.println(sb.toString());
    }
}
