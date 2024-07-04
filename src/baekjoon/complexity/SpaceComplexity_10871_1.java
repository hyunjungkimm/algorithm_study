package src.baekjoon.complexity;

import java.util.Scanner;

public class SpaceComplexity_10871_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < N; i++) {
            if(arr[i] < X) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
