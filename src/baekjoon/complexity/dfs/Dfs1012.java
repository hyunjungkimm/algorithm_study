package src.baekjoon.complexity.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dfs1012 {
    static int M, N, K;
    static boolean[][] visited;
    static int[][] adjMatrix;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >=0 && cx < M && cy < N) {
                if(adjMatrix[cx][cy] == 1 && !visited[cx][cy]) {
                    dfs(cx, cy);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String[] arr = br.readLine().split(" ");
            M = Integer.parseInt(arr[0]);
            N = Integer.parseInt(arr[1]);
            K = Integer.parseInt(arr[2]);
            adjMatrix = new int[M][N];
            int count = 0;

            for (int i = 0; i < K; i++) {
                String[] location = br.readLine().split(" ");
                int x = Integer.parseInt(location[0]);
                int y = Integer.parseInt(location[1]);

                adjMatrix[x][y] = 1;
            }

            visited = new boolean[M][N];

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(adjMatrix[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}




