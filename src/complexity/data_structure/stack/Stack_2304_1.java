package src.complexity.data_structure.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_2304_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1002];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
        }

        Stack<Integer> rightStack = new Stack<>();
        int rightLength = 0;
        int rightWidth = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) continue;
            else {
                if(rightStack.isEmpty()) {
                    rightStack.push(arr[i]);
                    rightLength = i;
                } else {
                    if(rightStack.peek() < arr[i]) {
                        int height = rightStack.pop();
                        rightWidth += height * (i - rightLength);

                        rightLength = i;
                        rightStack.push(arr[i]);
                    }
                }
            }
        }

        int leftLength = 0;
        int leftWidth = 0;
        Stack<Integer> leftStack = new Stack<>();

        for(int i = arr.length - 3; i >= rightLength; i--) {
            if(arr[i] == 0) continue;
            else {
                if(leftStack.isEmpty()) {
                    leftStack.push(arr[i]);
                    leftLength = i;
                } else {
                    if(leftStack.peek() < arr[i]) {
                        int height = leftStack.pop();
                        leftWidth += height * (leftLength - i);

                        leftLength = i;
                        leftStack.push(arr[i]);
                    }
                }
            }
        }
        int answer = 0;
        if(!rightStack.isEmpty() && !leftStack.isEmpty()) {
            if(leftStack.peek() == rightStack.peek()) {
                int length = 0;
                if(leftLength == rightLength) {
                    length = 1;
                } else {
                    length = leftLength - rightLength + 1;
                }
                int height = leftStack.pop();
                rightStack.pop();
                answer = length * height;
            }
        }

        answer += leftWidth + rightWidth;
        System.out.println(answer);
    }
}
