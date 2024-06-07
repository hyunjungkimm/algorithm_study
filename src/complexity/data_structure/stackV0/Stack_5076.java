package src.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_5076 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while(!(input.equals("#"))) {
            input = br.readLine();
            if(input.equals("#")) break;
            char[] arr = input.toCharArray();
            StringBuffer sb = new StringBuffer();
            Stack<String> stack = new Stack<>();

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '<') {
                    i++;

                    if(arr[i] == '/') {
                        i++;
                        while(arr[i] != '>') {
                            sb.append(arr[i]);
                            i++;
                        }
                        if(!stack.empty()) {
                            if(stack.peek().equals(sb.toString())) {
                                stack.pop();
                                sb.setLength(0);
                            }
                        }
                    }else{
                        while(arr[i] != '>') {
                            if (arr[i] == '/'){
                                sb.setLength(0);
                                break;
                            }
                            if(arr[i] == ' ' && arr[i+1] !='/') break;
                            sb.append(arr[i]);
                            i++;
                        }
                    }

                    if(sb.length() > 0) {
                        stack.push(sb.toString());
                        sb.setLength(0);
                    }
                }
            }

            if(!stack.isEmpty()) {
                System.out.println("illegal");
            }else {
                System.out.println("legal");
            }
        }

    }
}
