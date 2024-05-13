package src.complexity.greedy;

import java.util.Scanner;

public class Greedy_11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = N-1; i >= 0; i--) {
            int divide = K / arr[i];
            if(divide > 0) {
                answer += divide;
                K = K % arr[i];
            }
        }
        System.out.println(answer);
    }
}
