/**
 * Author    : 김현정
 * Date      : 2024.09.05(목)
 * Runtime   : 118 ms
 * Memory    : 17612 KB
 * Algorithm : [백준]백트래킹 - 1182 부분수열의합
 */
package src.baekjoon.complexity.back_tracking;

import java.util.Scanner;

public class 부분수열의합_1182 {
    static int answer = 0;
    static int n, s;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int current, int sum) {
        if(current == n) return;

        if(sum + arr[current] == s) {
            answer++;
        }
        dfs(current+1, sum);
        dfs(current+1, sum+arr[current]);
    }
}
