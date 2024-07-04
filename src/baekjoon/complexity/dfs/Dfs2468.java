package src.baekjoon.complexity.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfs2468 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] cx = {1, 0, -1, 0};
    static int[] cy = {0, -1, 0, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int count;
        int answer = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for(int height = 1; height <= max; height++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && arr[i][j] > height) {
                        dfs(i, j, height);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }


    public static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
           int nx = x + cx[i];
           int ny = y + cy[i];

           if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
               if(!visited[nx][ny] && arr[nx][ny] > height) {
                   dfs(nx, ny, height);
               }
           }
       }


    }

}
