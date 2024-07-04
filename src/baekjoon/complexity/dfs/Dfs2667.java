package src.baekjoon.complexity.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dfs2667 {
    static boolean[][] visited;
    static List<Integer> answer;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static int N;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            char[] home =  br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                arr[i][j] = home[j] - 48;
            }
        }

        visited = new boolean[N][N];
        answer = new ArrayList<>();

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {

                if(!visited[x][y] && arr[x][y] == 1) {
                    dfs(x, y);
                    answer.add(sum);
                    sum = 0;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int count : answer) {
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        sum++;

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
                if(arr[cx][cy] == 1 && !visited[cx][cy]) {
                    dfs(cx, cy);
                }
            }
        }
    }
}
