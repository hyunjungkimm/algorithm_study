package src.baekjoon.complexity.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dfs2583 {
    static boolean [][] visited;
    static int N, M, K;
    static int [][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Integer> answer = new ArrayList<>();

    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new int[N][M];

        for(int i = 0 ; i < K ; i++){
            String[] coordinates = br.readLine().split(" ");
            int startX = Integer.parseInt(coordinates[0]);
            int startY = Integer.parseInt(coordinates[1]);
            int endX = Integer.parseInt(coordinates[2]);
            int endY = Integer.parseInt(coordinates[3]);

            for(int x = startX; x < endX; x++) {
                for(int y = startY; y < endY; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    dfs(i, j);
                    answer.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int size : answer) {
            System.out.print(size+ " ");
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i ++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < N && cy < M) {
                if(arr[cx][cy] == 0 && !visited[cx][cy]){
                    dfs(cx, cy);
                }
            }
        }
    }
}
