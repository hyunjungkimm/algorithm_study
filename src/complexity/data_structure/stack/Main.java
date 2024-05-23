package src.complexity.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        Stack<Long> stack = new Stack<>();
        long max = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                long number = stack.pop();
                if (stack.size() > 0) {
                    for (int j = i - 1; j > 0; j--) {
                        if (arr[j] == stack.peek()) {
                            max = Math.max(max, number * (i - j -1));
                            break;
                        }
                    }
                } else {
                    max = Math.max(max, number * i);
                }
            }
            stack.push(arr[i]);
        }

        while (!stack.isEmpty()){
            long number = stack.pop();
            int index = 0;
            for (int j = N -1 ; j >= 0; j--) {
                index = j;
                break;
            }
            if (stack.size() > 0) {
                for (int j = N -1 ; j >= 0; j--) {
                    if(arr[j] == stack.peek()){
                        max = Math.max(max, number * (index-j));
                        break;
                    }
                }
            } else {
                max = Math.max(max, number * N);
            }
        }



        System.out.println(max);

    }
}
