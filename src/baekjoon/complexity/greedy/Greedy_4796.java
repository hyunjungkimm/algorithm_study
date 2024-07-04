package src.baekjoon.complexity.greedy;

import java.util.Scanner;

public class Greedy_4796 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        while(true){

            int L = scanner.nextInt();
            int P = scanner.nextInt();
            int V = scanner.nextInt();

            if(L == 0 && P == 0 && V ==0) break;

            int maxDay =  (V / P) * L + Math.min(L, V % P);
            System.out.println("Case "+ n++ + ": " + maxDay);
        }
    }
}
