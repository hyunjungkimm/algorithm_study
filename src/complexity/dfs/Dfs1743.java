package src.complexity.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dfs1743 {
    static int N,M,K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int max = 0;
    static int sum = 0;

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        sum++;
        for(int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if(!visited[cx][cy] && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        K = Integer.parseInt(size[2]);
        arr = new int[M][N];

        for(int i = 0; i < K; i++){
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]) - 1;
            int x = Integer.parseInt(input[1]) - 1;
            arr[x][y] = 1;
        }

        visited = new boolean[M][N];

        for(int x = 0; x < M; x++){
            for(int y = 0; y < N; y++){
                if(arr[x][y] == 1 && !visited[x][y]){
                    dfs(x,y);
                    max = Math.max(sum, max);
                    sum = 0;
                }
            }
        }
        System.out.println(max);
    }

}
