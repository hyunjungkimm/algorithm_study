package src.complexity.brute_force;

import java.util.Scanner;

public class BruteForce_2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;

        for(int i = n-1; i > 0; i--){
            char[] arr = Integer.toString(i).toCharArray();
            int sum = i;
            for(int j = 0; j < arr.length; j++){
                sum += Character.getNumericValue(arr[j]);
            }

            if(sum == n){
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
