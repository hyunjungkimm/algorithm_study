package src.baekjoon.complexity;

import java.util.Scanner;

public class TimeComplexity_8393_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = (n *(1+n))/2;
        System.out.println(sum);
    }
}
