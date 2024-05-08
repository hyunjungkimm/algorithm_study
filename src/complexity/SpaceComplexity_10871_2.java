package src.complexity;

import java.util.Scanner;

public class SpaceComplexity_10871_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            if(input < X) {
                System.out.print(input + " ");
            }
        }
    }
}
