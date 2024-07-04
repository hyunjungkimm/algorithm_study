package src.baekjoon.complexity.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class BruteForce_2309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        int mockA = 0;
        int mockB = 0;
        for(int i = 0; i < 9; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    mockA = i;
                    mockB = j;
                    break;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if (mockA == i || mockB == i) continue;
            System.out.println(arr[i]);
        }
    }
}
