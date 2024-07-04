package src.baekjoon.complexity.divide_and_conquer;

import java.util.Scanner;

public class DivideAndConquer_1629 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();

        System.out.println(multiplication(A, B, C));
    }

    static long multiplication(long A, long B, long C) {
        if(B == 0) return 1;

        long half = multiplication(A, B/2, C);
        long result = (half * half) % C;

        if(B % 2 == 1) {
            result = (A * result) % C;
        }

        return result;
    }
}
