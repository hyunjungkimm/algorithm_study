package src.leetcode;

import java.util.Stack;

class Solution20
{

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean result = false;

        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                if(arr[i] == ')' || arr[i] == ']' || arr[i] == '}' ) {
                    return false;
                }
            }

            if(arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            }

            if(arr[i] == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                }else {
                    return false;
                }
            } else if(arr[i] == '}'){
                if(stack.peek() == '{') {
                    stack.pop();
                }else {
                    return false;
                }
            } else if(arr[i] == ']') {
                if(stack.peek() == '[') {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        for(int i = 0; i < input.length; i++) {
            if(input[i] == '(' || input[i] == '[' || input[i] == '{') {
                stack.push(input[i]);
            } else if(input[i] == ')') {
                if(stack.empty() || stack.peek() != '(') {
                    return false;
                }else if(stack.peek() == '(') {
                    stack.pop();
                }
            } else if(input[i] == '}') {
                if(stack.empty() || stack.peek() != '{') {
                    return false;
                }else if(stack.peek() == '{') {
                    stack.pop();
                }
            } else if(input[i] == ']') {
                if(stack.empty() || stack.peek() != '[') {
                    return false;
                }else if(stack.peek() == '[') {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}
