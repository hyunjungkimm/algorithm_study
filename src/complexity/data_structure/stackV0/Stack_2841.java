package src.complexity.data_structure.stackV0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Stack_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int count = 0;
        Map<Integer,Stack> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String[] number = br.readLine().split(" ");
            int tone = Integer.parseInt(number[0]);
            int flat = Integer.parseInt(number[1]);
            if(map.containsKey(tone)) {
                Stack<Integer> stack = map.get(tone);
                if (!stack.isEmpty()){
                    if(stack.peek() < flat) {
                        stack.push(flat);
                        count++;
                    } else if(stack.peek() > flat){
                        while(stack.size() > 0 && stack.peek() > flat){
                            stack.pop();
                            count++;
                        }
                        if(stack.isEmpty()) {
                            stack.push(flat);
                            count++;
                        }else if(stack.peek() != flat){
                            stack.push(flat);
                            count++;
                        }
                    }
                }
            }else {
                Stack<Integer> stack = new Stack<>();
                stack.push(flat);
                count++;
                map.put(tone,stack);
            }
        }

        System.out.println(count);
    }
}
